terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
    }
  }
}

provider "aws" {
  access_key = "asdf"
  secret_key = "abcd"
  region     = "eu-central-1"
  s3_use_path_style         = true
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  endpoints {
    sqs = "http://localhost:4566"
  }
}

resource "aws_sqs_queue" "created_queue" {
    name = "created-queue"
}

resource "aws_sqs_queue" "updated_queue" {
    name = "updated-queue"
}

resource "aws_sqs_queue" "deleted_queue" {
    name = "deleted-queue"
}

resource "aws_sqs_queue" "email_queue" {
    name = "email-queue"
}





