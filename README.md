# Jenkins Pipeline for API Testing with Newman

## Project Overview

This project aims to automate API testing through the utilization of Newman, the command-line collection runner for Postman. The pipeline is constructed using Jenkins, enabling continuous integration and deployment of API tests. Its purpose is to ensure that all endpoints are thoroughly tested and that comprehensive reports are generated to provide insights into the API's performance and functionality.

## Features

- **Automated API Testing**: The pipeline triggers Newman to execute API tests defined within Postman collections.
- **HTML Report Generation**: Upon completion of the tests, an HTML report is generated using the `newman-reporter-html`, summarizing the test results and assertions.
- **Artifact Archiving**: The generated reports are archived and published within Jenkins, allowing for easy access and review.
- **Error Handling**: The pipeline incorporates steps to manage errors effectively, providing clear feedback on the success or failure of each stage.

## Prerequisites

- **Jenkins**: Ensure that Jenkins is installed and properly configured.
- **Node.js and npm**: Install Node.js and npm on the Jenkins server.
- **Newman**: The Newman package and `newman-reporter-html` must be installed, either globally or within the project.

## Pipeline Stages

1. **Prepare Reports Directory**: Creates a directory for storing Newman reports.
2. **Install Newman Reporter**: Installs the `newman-reporter-html` package locally to facilitate HTML report generation.
3. **Run Collection API Tests**: Executes the API tests defined in the Postman collection using Newman.
4. **Post Actions**: Archives the generated report and publishes it within Jenkins.

## Usage Instructions

To execute the pipeline:

1. Configure your Jenkins job utilizing the provided Jenkinsfile.
2. Ensure that the Postman collection JSON file is accessible within the pipeline.
3. Trigger the job and monitor the stages for completion.
4. Access the generated reports from the specified directory in Jenkins.

## License

This project is licensed under the MIT License. 
