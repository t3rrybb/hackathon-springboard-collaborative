#!/bin/bash

aws dynamodb put-item \
    --table-name service-provider \
        --item '{"id": {"S": "001"},
		"name": {"S": "Employment Service Provider 1"},
		"description": {"S": "Employment Service Provider 1"},
		"website": {"S": "https://nonexistent.org"},
		"email": {"S": "support@nonexistent.org"},
		"phone": {"S": "000-000-0001"},
		"active": {"B": "true"}
		}'
	
# '{"id": {"S": "001"}, 		"name": {"S": "Employment Service Provider 1"}, 		"description": {"S": "Employment Service Provider #1"}, 		"website": {"S": "https://nonexistent.org"}, 		"email": {"S": "support@nonexistent.org"}, 		"phone": {"S": "000-000-0001"}, 		"active": {"B": true}' 
