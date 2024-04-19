# aws-s3-presigned-url
Microservices built with Java - Spring Boot and based on Clean Architecture to generate a pre-signed URL of an AWS S3 Bucket object

## Create src/main/resources/application.properties
```
spring.application.name=ms_s3_presigned_url
```

## Create an IAM Policy
1. In the AWS Management Console, open the Services menu.
2. In the IAM dashboard, click on Users in the navigation pane on the left.
3. Clic on Create a user.
4. Wtrite a name for the user and clic on Next.
5. Select Attach policies directly.
6. Clic on Create Policy.
7. Attach the next policy:
    ```
    {
        "Version": "2012-10-17",
        "Statement": [
            {
                "Effect": "Allow",
                "Action": "s3:GetObject",
                "Resource": "arn:aws:s3:::your-bucket-name/*"
            }
        ]
    }
    ```
8. Write policy name.
9. Clic on Create Policy.
10. Search the policy created before.
11. Clic on Next.
12. Clic on Create User.

## Generate AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY
1. In the AWS Management Console, open the Services menu.
2. In the IAM dashboard, click on Users in the navigation pane on the left.
3. Clic on the user created before.
4. Clic on Security Credential tabs.
5. Select Local Code
6. Check: I understand the above recommendation and want to proceed to create an access key.
7. Clic on Next.
8. Write a Description tag value.
9. Clic on Create access key.
10. Copy Access key and Secret access key

## Create AWS Credentials File
You can create or update an AWS credentials file. By default, this file is located at ~/.aws/credentials on Linux and macOS, or C:\Users\USERNAME\.aws\credentials on Windows. The file should look like this:
```
[default]
aws_access_key_id = your_access_key_id
aws_secret_access_key = your_secret_access_key
```