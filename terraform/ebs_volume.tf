resource "aws_ebs_volume" "database_server_volume" {
  availability_zone = "us-east-1c" # Replace with your desired availability zone
  size              = 8
  type              = "gp3"
  tags = {
    Name = "My first EBS Volume"
  }

  # Prevent the EBS volume from being destroyed
  lifecycle {
    prevent_destroy = true
    ignore_changes = [
      size,
      tags,
    ]
  }
}

# Attach the EBS volume to the EC2 instance
resource "aws_volume_attachment" "database_server_attachment" {
  device_name  = "/dev/xvdf"
  volume_id    = aws_ebs_volume.database_server_volume.id
  instance_id  = aws_instance.service_authentication.id
  force_detach = true # Force detach in case it's attached elsewhere
}