package com.poc.aws.ms_s3_presigned_url.infraestructure.entryPoints.api.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestResponse {
    private Boolean status;
    private String url;
}
