# Core Banking Modernization — DevOps & SRE Project

## Project Overview

This project demonstrates the modernization of a legacy core banking application using cloud-native and DevOps practices. The goal is to build a foundation for a secure, scalable, automated, and observable banking platform.

The project simulates the migration of a legacy banking application toward a modern architecture using AWS, Infrastructure as Code, containers, and CI/CD tools.

## Technology Stack

- **Cloud:** Amazon Web Services (AWS)
- **Infrastructure as Code:** Terraform
- **Application:** Java, Spring Boot
- **Database:** PostgreSQL
- **Containers:** Docker
- **Container Orchestration:** Kubernetes, Amazon EKS
- **CI/CD:** Jenkins, Argo CD
- **Monitoring:** Prometheus, Grafana, AWS CloudWatch
- **Version Control:** Git, GitHub

## Project Components

### 1. Banking Application
A Spring Boot application designed to demonstrate core banking functionality, including customer management, accounts, and transactions.

### 2. Infrastructure as Code
Terraform configuration files organize the AWS infrastructure components, including networking, IAM, and Kubernetes-related resources.

### 3. Containerization and Deployment
The project is designed to use Docker and Kubernetes to package and deploy the application consistently.

### 4. CI/CD Automation
Jenkins and Argo CD are included in the planned delivery workflow for build, deployment, and GitOps automation.

### 5. Monitoring and Reliability
Prometheus, Grafana, and CloudWatch are planned for monitoring application health, infrastructure metrics, and service reliability.

## Repository Structure

```text
core-banking-modernization/
├── legacy-app/
├── terraform/
├── docs/
├── .gitignore
└── README.md
```

## Project Status

This is an ongoing hands-on DevOps and SRE portfolio project. Application development and repository setup are in progress. Infrastructure provisioning, automated delivery, Kubernetes deployment, and monitoring will be validated as each stage is completed.

## Learning Objectives

- Manage infrastructure through Terraform.
- Apply containerization and Kubernetes deployment practices.
- Build CI/CD and GitOps workflows.
- Implement monitoring, troubleshooting, and reliability practices.
- Document infrastructure and application architecture.

## Disclaimer

This is a learning and portfolio project. It does not represent a production banking system and contains no real customer banking data.

## Author

DevOps / Site Reliability Engineering Portfolio Project