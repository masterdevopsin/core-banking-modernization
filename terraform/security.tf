resource "aws_security_group" "alb_sg" {

  name        = "legacy-bank-alb-sg"
  description = "Security Group for Application Load Balancer"
  vpc_id      = aws_vpc.main.id

  ingress {

    description = "Allow HTTP"

    from_port = 80
    to_port   = 80

    protocol = "tcp"

    cidr_blocks = ["0.0.0.0/0"]

  }

  ingress {

    description = "Allow HTTPS"

    from_port = 443
    to_port   = 443

    protocol = "tcp"

    cidr_blocks = ["0.0.0.0/0"]

  }

  egress {

    from_port = 0
    to_port   = 0

    protocol = "-1"

    cidr_blocks = ["0.0.0.0/0"]

  }

  tags = {

    Name = "legacy-bank-alb-sg"

  }

}

resource "aws_security_group" "eks_nodes_sg" {

  name        = "legacy-bank-eks-nodes-sg"
  description = "Security Group for EKS Worker Nodes"
  vpc_id      = aws_vpc.main.id

  # Allow HTTP traffic from ALB
  ingress {
    description     = "HTTP from ALB"
    from_port       = 80
    to_port         = 80
    protocol        = "tcp"
    security_groups = [aws_security_group.alb_sg.id]
  }

  # Allow communication between worker nodes
  ingress {
    description = "Node to Node communication"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    self        = true
  }

  # Allow all outbound traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "legacy-bank-eks-nodes-sg"
  }
}



resource "aws_security_group" "rds_sg" {

  name        = "legacy-bank-rds-sg"
  description = "Security Group for PostgreSQL"
  vpc_id      = aws_vpc.main.id

  ingress {

    description = "PostgreSQL from EKS Worker Nodes"

    from_port = 5432
    to_port   = 5432

    protocol = "tcp"

    security_groups = [aws_security_group.eks_nodes_sg.id]

  }

  egress {

    from_port = 0
    to_port   = 0

    protocol = "-1"

    cidr_blocks = ["0.0.0.0/0"]

  }

  tags = {

    Name = "legacy-bank-rds-sg"

  }

}