package org.springboard.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

@Configuration
//give dao packages here
//@EnableDynamoDBRepositories(basePackages = "")
public class DynamoDBConfig {

    @Value("${amazon.aws.accesskey}")
    private String accessKey;

    @Value("${amazon.aws.secretkey}")
    private String secretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey))).build();
    }

}