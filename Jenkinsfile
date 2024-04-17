pipeline {
    agent any

    tools {
        maven 'MAVEN3' // Ensure Maven is defined in Global Tool Configuration in Jenkins
        jdk 'JDK' // Ensure JDK is defined in Global Tool Configuration in Jenkins
    }

    triggers {
        pollSCM('H */4 * * *') // Polls SCM every 4 hours; adjust as necessary
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/beyuneek/Comp-367-GroupProject/', branch: 'main' // Ensure the correct repo URL and branch
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests' // Uses bat for Windows batch commands, skips tests during build
            }
        }

        stage('Test') {
            steps {
                script {
                    // Check if there are test files in the specified directory
                    if (fileExists('src\\test\\java')) {
                        bat 'mvn test' // Runs tests if they exist
                        junit 'target\\surefire-reports\\*.xml' // Publishes test results
                        jacoco(execPattern: 'target\\jacoco.exec') // Collects code coverage metrics
                    } else {
                        echo 'No test files exist, skipping tests.'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'Build and tests were successful.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
