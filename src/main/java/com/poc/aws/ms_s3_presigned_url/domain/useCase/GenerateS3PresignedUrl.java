package com.poc.aws.ms_s3_presigned_url.domain.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.S3PresignedUrl;
import com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.gateways.S3Repository;
import com.poc.aws.ms_s3_presigned_url.domain.useCase.interfaces.IGenerateS3PresignedUrlUseCase;

// import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

@Service
// @RequiredArgsConstructor
public class GenerateS3PresignedUrl implements IGenerateS3PresignedUrlUseCase{

    @Autowired
    private S3Repository s3Repository;

    public String getGeneratedS3PresignedUrl(S3PresignedUrl presignedUrl) {

        GetObjectRequest getObject = s3Repository.GetObject(presignedUrl.getBucketName(), presignedUrl.getObjectKey());

        GetObjectPresignRequest GetObjectPresign = s3Repository.GetObjectPresign(getObject, presignedUrl.getExpirationMinutes());

        PresignedGetObjectRequest presignedGetObjectRequest = s3Repository.PresignedGetObject(GetObjectPresign);

        return presignedGetObjectRequest.url().toString();
    }
}
