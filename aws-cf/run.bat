echo off
aws cloudformation create-stack --stack-name %1 --template-body file://itsa-master2-vpc.cfn.json --parameters file://launch-params.json --capabilities CAPABILITY_IAM --disable-rollback