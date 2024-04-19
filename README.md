## Create src/main/resources/application.properties
```
spring.application.name=ms_s3_presigned_url
```

## Create AWS Credentials File
You can create or update an AWS credentials file. By default, this file is located at ~/.aws/credentials on Linux and macOS, or C:\Users\USERNAME\.aws\credentials on Windows. The file should look like this:
```
[default]
aws_access_key_id = your_access_key_id
aws_secret_access_key = your_secret_access_key
```