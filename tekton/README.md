# Tekton Pipeline CI/CD Configuration

Prerequisite:

1. Install [gomplate](https://gomplate.ca/)
2. Create the k8s namespace that will contain the application
   1. Define [Git Clone](git-clone.yaml) Task
   2. Define [Docker Build](docker-build.yaml) Task
   3. Define [Kubectl Deploy](kubectl-deploy.yaml) Task
   4. Define [Pipeline](pipeline.yaml) that organizes the above Tasks for execution
   5. Define [PipelineRun](pipeline-run.yaml) that executes the above Tasks as defined in the Pipeline
3.
