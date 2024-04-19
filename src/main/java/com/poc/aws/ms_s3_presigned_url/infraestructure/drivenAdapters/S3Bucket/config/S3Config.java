package com.poc.aws.ms_s3_presigned_url.infraestructure.drivenAdapters.S3Bucket.config;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;

public class S3Config {
    public S3Client s3Client(S3BucketConnectionProperties connectionProperties){
        return S3Client.builder()
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(connectionProperties.getAccessKey(), connectionProperties.getSecretKey())))
            .region(Region.of(connectionProperties.getRegion()))
            .build();
    }
}
