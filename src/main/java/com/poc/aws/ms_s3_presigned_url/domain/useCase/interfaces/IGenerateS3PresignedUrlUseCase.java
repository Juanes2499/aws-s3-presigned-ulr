package com.poc.aws.ms_s3_presigned_url.domain.useCase.interfaces;

import com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.S3PresignedUrl;

public interface IGenerateS3PresignedUrlUseCase {
    String getGeneratedS3PresignedUrl(S3PresignedUrl presignedUrl);
}
