terraform {
  backend "s3" {
    bucket = "terraform.ruchij.com"
    key = "$name;format="normalize"$.tfstate"
    region = "ap-southeast-2"
  }
}

provider "aws" {
  version = "~> 2.0"
  region = "ap-southeast-2"
}

resource "aws_ecr_repository" "ecr" {
  name = "$name;format="normalize"$"
}

output "ecr_url" {
  value = "\${aws_ecr_repository.ecr.repository_url}"
}
