package com.poc.aws.ms_s3_presigned_url.infraestructure.drivenAdapters.S3Bucket.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "adapter.aws.s3")
public class S3BucketConnectionProperties {
    private String accessKey;
    private String secretKey;
    private String region;
    private String bucketName;
}
