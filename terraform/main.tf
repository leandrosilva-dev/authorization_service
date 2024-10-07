terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  region = "us-east-1"
}

resource "aws_instance" "service_authentication" {
  ami           = "ami-0182f373e66f89c85"
  instance_type = "t2.micro"

  key_name = "development_database_key_pair"

  tags = {
    Name = "Terraform with Docker"
  }

  # Security group block
  vpc_security_group_ids = [aws_security_group.allow_ssh.id]

  # Attach a user data script (optional)
  user_data = <<-EOF
              #!/bin/bash
              # Mount the EBS volume to /mnt/data
              # Create a directory for the Docker volume mount point
              sudo mkdir -p /mnt/authentication_service/data/h2

              # Mount the EBS volume
              sudo mkfs -t ext4 /dev/xvdf
              sudo mount /dev/xvdf /mnt/authentication_service/data/h2
              sudo chmod 777 /mnt/authentication_service/data/h2  # Allow H2 to write to this directory

              sudo yum update -y
              sudo yum install -y docker
              sudo service docker start
              sudo usermod -a -G docker ec2-user
              sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
              sudo chmod +x /usr/local/bin/docker-compose
              EOF 
}

# Security group to allow SSH and Postgres traffic
resource "aws_security_group" "allow_ssh" {
  name_prefix = "terraform-sg-"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allow SSH from anywhere (for testing)
  }

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allow Postgres access (limit to your IP for production)
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}