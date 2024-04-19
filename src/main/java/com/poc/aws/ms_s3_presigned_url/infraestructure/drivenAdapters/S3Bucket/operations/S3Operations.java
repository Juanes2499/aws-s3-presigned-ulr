package com.poc.aws.ms_s3_presigned_url.infraestructure.drivenAdapters.S3Bucket.operations;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.gateways.S3Repository;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.regions.Region;
import org.springframework.beans.factory.annotation.Value;

@Component
@RequiredArgsConstructor
public class S3Operations implements S3Repository {

    // @Value("${aws.accessKeyId}")
    // private String accessKeyId;

    // @Value("${aws.secretKey}")
    // private String secretAccessKey;

    public GetObjectRequest GetObject(String bucketName, String objectKey){
        // Create a GetObjectRequest
        GetObjectRequest getObjectRequest = GetObjectRequest
            .builder()
            .bucket(bucketName)
            .key(objectKey)
            .build();

        return getObjectRequest;
    }

    public GetObjectPresignRequest GetObjectPresign(GetObjectRequest getObjectRequest, Integer expirationMinutes){
        // Create a GetObjectPresignRequest to specify the signature duration
        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest
            .builder()
            .signatureDuration(Duration.ofMinutes(10))
            .getObjectRequest(getObjectRequest)
            .build();

        return getObjectPresignRequest;
    }

    public PresignedGetObjectRequest PresignedGetObject(GetObjectPresignRequest getObjectPresignRequest){

        // Create an S3Presigner using the default region and credentials.
        S3Presigner presigner = S3Presigner
            .builder()
            .region(Region.US_EAST_1) // Adjust the region as needed
            .build();

        // Generate the presigned request
        PresignedGetObjectRequest presignedGetObjectRequest = presigner.presignGetObject(getObjectPresignRequest);

        presigner.close();

        return presignedGetObjectRequest;
    }
}
