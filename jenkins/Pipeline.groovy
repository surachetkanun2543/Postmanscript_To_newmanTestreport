pipeline {
    agent any

    stages {
        stage('Prepare Reports Directory') {
            steps {
                sh 'mkdir -p /var/lib/jenkins/collection'
            }
        }
        
        stage('Install Newman') {
            steps {
                script {
                    // Install the newman 
                    sh 'npm install newman --legacy-peer-deps --prefix /var/lib/jenkins/collection'
                }
            }
        }
        
        stage('Install Newman Reporter') {
            steps {
                script {
                    // Install the newman-reporter-html package locally
                    sh 'npm install newman-reporter-html --legacy-peer-deps --prefix /var/lib/jenkins/collection'
                }
            }
        }

        stage('Run Collection API Tests') {
            steps {
                // Run Newman tests and export the report to the specified location
                sh 'newman run /var/lib/jenkins/Postman_to_Newman.postman_collection.json -r html --reporter-html-export /var/lib/jenkins/collection/newman-report.html'
            }
        }
        
    }

    post {
        always {
            // Use absolute path for archiving artifacts
            archiveArtifacts artifacts: '/var/lib/jenkins/collection/newman-report.html', allowEmptyArchive: true

            // Use absolute path for publishing the HTML report
            publishHTML (target: [
                allowMissing: true,
                keepAll: true,
                reportDir: '/var/lib/jenkins/collection',
                reportFiles: 'newman-report.html',
                reportName: 'newman-report'
            ])
        }

        success {
            echo "Pipeline completed successfully! All stages are finished."
        }

        failure {
            echo "Pipeline failed. Please check the failing stage."
        }
    }
}