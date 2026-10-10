resource "aws_eks_cluster" "main" {

  name     = "legacy-bank-cluster"
  role_arn = aws_iam_role.eks_cluster_role.arn

  vpc_config {

    subnet_ids = [

      aws_subnet.public_1.id,
      aws_subnet.public_2.id,

      aws_subnet.private_1.id,
      aws_subnet.private_2.id

    ]

    security_group_ids = [

      aws_security_group.eks_nodes_sg.id

    ]

  }

  depends_on = [

    aws_iam_role_policy_attachment.eks_cluster_policy

  ]

  tags = {

    Name = "legacy-bank-cluster"

  }

}


resource "aws_eks_node_group" "main" {
  cluster_name    = aws_eks_cluster.main.name
  node_group_name = "legacy-bank-workers"
  node_role_arn   = aws_iam_role.eks_node_role.arn

  subnet_ids = [
    aws_subnet.private_1.id,
    aws_subnet.private_2.id
  ]

  instance_types = ["t3.medium"]

  scaling_config {
    desired_size = 2
    min_size     = 2
    max_size     = 4
  }

  depends_on = [
    aws_iam_role_policy_attachment.worker_node_policy,
    aws_iam_role_policy_attachment.ecr_readonly,
    aws_iam_role_policy_attachment.eks_cni
  ]
}