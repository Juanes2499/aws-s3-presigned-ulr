package com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.gateways;

import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

public interface S3Repository {
    GetObjectRequest GetObject(String bucketName, String objectKey);
    GetObjectPresignRequest GetObjectPresign(GetObjectRequest getObjectRequest, Integer expirationMinutes);
    PresignedGetObjectRequest PresignedGetObject(GetObjectPresignRequest getObjectPresignRequest);
}
