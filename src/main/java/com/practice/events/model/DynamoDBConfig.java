package com.practice.events.model;

//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
//import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;

//@Configuration
//@EnableDynamoDBRepositories
public class DynamoDBConfig {

//    @Value("${amazon.dynamodb.endpoint}")
//    private String amazonDynamoDBEndpoint;
//
//    @Value("${cloud.aws.credentials.accessKey}")
//    private String amazonAWSAccessKey;
//
//    @Value("${cloud.aws.credentials.secretkey}")
//    private String amazonAWSSecretKey;
//
//    @Bean
//    public AmazonDynamoDB amazonDynamoDB() {
//        AmazonDynamoDB amazonDynamoDB
//                = new AmazonDynamoDBClient(amazonAWSCredentials());
//
//        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
//            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//        }
//
//        return amazonDynamoDB;
//    }
//
//    @Bean
//    public AWSCredentials amazonAWSCredentials() {
//        return new BasicAWSCredentials(
//                amazonAWSAccessKey, amazonAWSSecretKey);
//    }
}
