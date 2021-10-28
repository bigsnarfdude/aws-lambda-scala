# aws-lambda-scala



### Uploader for S3Lamba
```
aws lambda create-function \
--region us-west-2 \
--function-name lambda-function-in-scala \
--zip-file fileb://aws-lambda-scala/S3Lambda/target/scala-2.11/lambda-demo-assembly-1.0.jar \
--role arn:aws:iam::account-id:role/lambda_basic_execution  \
--handler com.snowplowanalytics::Main \
--runtime java8 \
--timeout 15 \
--memory-size 512
```


### Uploader for Kinesis
```
aws lambda create-function \
--region us-west-2 \
--function-name lambda-function-in-scala-kinesis \
--zip-file fileb://aws-lambda-scala/Kinesis/target/scala-2.11/lambda-in-scala-assembly-1.0.jar \
--role arn:aws:iam::account-id:role/lambda_basic_execution \
--handler com.snowplowanalytics.ProcessKinesisEvents::recordHandler \
--runtime java8 \
--timeout 15 \
--memory-size 512
```

### Update Kinesis Function
```
aws lambda update-function-code \
--region us-west-2 \
--function-name lambda-function-in-scala-kinesis \
--zip-file fileb://aws-lambda-scala/Kinesis/target/scala-2.11/lambda-in-scala-assembly-1.0.jar
```

.
