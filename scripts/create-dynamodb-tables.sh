#!/bin/bash

aws dynamodb create-table \
	--table-name service-provider \
	--attribute-definitions \
	AttributeName=id,AttributeType=S \
	--key-schema \
	AttributeName=id,KeyType=HASH \
	--provisioned-throughput \
	ReadCapacityUnits=5,WriteCapacityUnits=5 \
	--region us-east-1

aws dynamodb create-table \
        --table-name ParticipantTSC \
        --attribute-definitions AttributeName=id,AttributeType=N \
        --key-schema AttributeName=id,KeyType=HASH \
        --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1

aws dynamodb create-table \
        --table-name ParticipantTSC \
        --attribute-definitions AttributeName=id,AttributeType=N \
        --key-schema AttributeName=id,KeyType=HASH \
        --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1