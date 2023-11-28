![myacuity-logo](https://myacuity.com/wp-content/uploads/2021/06/brand.svg)
# Acuity SpringBoot Microservice Template


This project is a template SpringBoot microservice project to allow teams to quickly spin up new API services.  It is designed to be containerized and deployed to a kubernetes cluster (EKS).

This project includes:
- Swagger UI
- Spring Security
- Spring Actuator with Prometheus metrics and tracing
- Spring Data JPA
- Jenkinsfile and Dockerfile for pipeline
  - Postman configuration for API acceptance testing

## AWS CDK Deployables
TBD

## Service README

See [the actual project README](README_PROJECT.md) for more information.

## Deployment README

See [the deployment README](tekton/README.md) for more information.

## Template Usage

### Pre-requisites

1. The `tree` command is installed and available.
2. The `gomplate` command is installed and available.
3. Create a new repo using this repo as a template.
4. Locally edit [the configuration file](template_config.yaml) to pass in variables used to generate the codebase from the template.

### Generating the codebase

1. Run `./scripts/generate_codebase.sh` and commit/push the resulting changes, assuming they look good.
2. Setup repo access
3. Enable branch protections

