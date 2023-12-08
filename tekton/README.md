# Tekton Pipeline CI/CD Configuration

Prerequisite:

1. Install [gomplate](https://gomplate.ca/)
2. Set GitHub Actions Secret `KUBE_CONFIG_DATA` encoded in base64 (try `cat $HOME/.kube/config | base64`)
3. Customize the project config in [config.yaml](config.yaml)
4. Configure and execute the pipeline that will contain the application
   1. Define [Docker Secret](create-secret.sh) in Tekton
   2. Define [Service Account](service-account.yaml) using the Docker Secret
   3. Define [Git Clone](git-clone.yaml) Task
   4. Define [Docker Build](docker-build.yaml) Task
   5. Define [Kubectl Deploy](kubectl-deploy.yaml) Task
   6. Define [the Service Account](service-account.yaml)
   7. Define [Pipeline](pipeline.yaml) that organizes the above Tasks for execution
   8. Define [PipelineRun](pipeline-run.yaml) that executes the above Tasks as defined in the Pipeline
