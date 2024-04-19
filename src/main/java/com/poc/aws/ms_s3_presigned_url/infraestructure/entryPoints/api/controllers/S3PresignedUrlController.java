package com.poc.aws.ms_s3_presigned_url.infraestructure.entryPoints.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.aws.ms_s3_presigned_url.domain.models.S3Bucket.S3PresignedUrl;
import com.poc.aws.ms_s3_presigned_url.domain.useCase.interfaces.IGenerateS3PresignedUrlUseCase;
import com.poc.aws.ms_s3_presigned_url.infraestructure.entryPoints.api.models.RequestResponse;

@RestController
@RequestMapping("/api/s3")
public class S3PresignedUrlController {

    @Autowired
    private IGenerateS3PresignedUrlUseCase generateS3PresignedUrlUseCase;

    @PostMapping("/presigned-url")
    public RequestResponse getPresignedUrl(@RequestBody S3PresignedUrl body) {

        RequestResponse requestResponse = new RequestResponse();

        try{
            String url =  generateS3PresignedUrlUseCase.getGeneratedS3PresignedUrl(body);
            requestResponse.setStatus(true);
            requestResponse.setUrl(url);
        } catch (Exception ex) {
            requestResponse.setStatus(false);
            requestResponse.setUrl(ex.toString());
        }

        return requestResponse;
    }
}
