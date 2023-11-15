# Tekton Pipeline CI/CD Configuration

Prerequisite: Create the k8s namespace that will contain the application

1. Define [Git Clone](git-clone.yaml) Task
2. Define [Docker Build](docker-build.yaml) Task
3. Define [Kubectl Deploy](kubectl-deploy.yaml) Task
