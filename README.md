# aws-lambda-scala


aws lambda create-function \
--region us-west-2 \
--function-name lambda-function-in-scala \
--zip-file fileb://aws-lambda-scala/S3Lambda/target/scala-2.11/lambda-demo-assembly-1.0.jar \
--role arn:aws:iam::account-id:role/lambda_basic_execution  \
--handler com.snowplowanalytics::Main \
--runtime java8 \
--timeout 15 \
--memory-size 512
