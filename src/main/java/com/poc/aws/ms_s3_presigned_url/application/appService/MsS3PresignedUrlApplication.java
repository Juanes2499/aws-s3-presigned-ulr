package com.poc.aws.ms_s3_presigned_url.application.appService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.poc.aws.ms_s3_presigned_url" )
public class MsS3PresignedUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsS3PresignedUrlApplication.class, args);
	}

}