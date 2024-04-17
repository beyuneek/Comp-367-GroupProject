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
                sh 'mvn clean install -DskipTests' // Skips tests during build
            }
        }

        stage('Test') {
            steps {
                script {
                    if (fileExists('src/test/java')) { // Checks if there are test files
                        sh 'mvn test' // Runs tests if they exist
                        junit 'target/surefire-reports/*.xml' // Publishes test results
                        jacoco(execPattern: 'target/jacoco.exec') // Collects code coverage metrics
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
