package com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class S3PresignedUrl {
    private String bucketName;
    private String objectKey;
    private Integer expirationMinutes;
}