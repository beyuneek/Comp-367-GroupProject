pipeline {
    agent any

    tools {
        maven 'M3'  // Change this based on your Jenkins configuration
        jdk 'Name_of_JDK_config'  // Change this based on your Jenkins configuration
    }

    stages {
        stage('Initialize') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                script {
                    def mvn = tool 'M3'
                    sh "${mvn}/bin/mvn clean compile"
                }
            }
        }

        stage('Unit Test') {
            steps {
                script {
                    def mvn = tool 'M3'
                    sh "${mvn}/bin/mvn test"
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                script {
                    def mvn = tool 'M3'
                    sh "${mvn}/bin/mvn deploy"
                }
            }
            when {
                branch 'main'
            }
        }
    }
}
