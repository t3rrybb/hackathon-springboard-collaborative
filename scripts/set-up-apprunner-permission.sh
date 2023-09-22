#!/bin/bash

aws iam create-role --role-name apprunner-role --assume-role-policy-document file://apprunner-role-policy.json

aws iam attach-role-policy --role-name apprunner-role --policy-arn arn:aws:iam::aws:policy/AmazonDynamoDBFullAccess

aws iam attach-role-policy --role-name apprunner-role --policy-arn arn:aws:iam::aws:policy/AmazonS3FullAccess
