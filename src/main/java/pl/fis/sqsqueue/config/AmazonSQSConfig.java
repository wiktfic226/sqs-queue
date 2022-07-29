package pl.fis.sqsqueue.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSQSConfig {
    @Value("${config.aws.sqs.url}")
    private String awsServiceEndpoint;

    @Value("${config.aws.region}")
    private String awsRegion;
    @Value("${config.aws.sqs.access-key}")
    private String awsAccessKey;
    @Value("${config.aws.sqs.secret-key}")
    private String awsSecretKey;

    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsServiceEndpoint, awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();
    }

    @Bean
    public AmazonSQS amazonSQS() {
        return AmazonSQSClient.builder()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsServiceEndpoint, awsRegion))
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
            .build();
    }
}
