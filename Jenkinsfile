pipeline {
    agent any  // This tells Jenkins to run this pipeline on any available agent

    tools {
        maven 'Maven'  // This specifies that Maven should be pre-installed on the agent
        jdk 'OpenJDK 17'  // Specifies the JDK version, adjust as necessary
    }

    stages {
        stage('Initialize') {
            steps {
                // Clean the workspace before getting the latest code
                cleanWs()
            }
        }
        
        stage('Checkout') {
            steps {
                // Checks out the source code from repository
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                // Runs Maven to compile the code
                script {
                    def mvnHome = tool 'Maven'  // Ensures Maven is configured in Global Tool Configuration
                    sh "${mvnHome}/bin/mvn clean compile"
                }
            }
        }

        stage('Unit Test') {
            steps {
                // Runs Maven to execute unit tests
                script {
                    def mvnHome = tool 'Maven'
                    sh "${mvnHome}/bin/mvn test"
                }
            }
            post {
                // Publishes the test results and code coverage report
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }

        stage('Deploy') {
            steps {
                // This stage could be used to deploy your application
                echo 'Deploying application...'
                script {
                    def mvnHome = tool 'Maven'
                    sh "${mvnHome}/bin/mvn deploy"
                }
            }
            when {
                // Specifies that the deploy should only run on the main branch
                branch 'main'
            }
        }
    }

    post {
        // Defines actions that should run after the pipeline is complete
        always {
            // For example, clean up the workspace
            cleanWs()
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
        unstable {
            echo 'Something is wrong with the build'
        }
        changed {
            echo 'The build status changed!'
        }
    }
}
