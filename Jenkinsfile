pipeline {
    agent any

    tools {
        maven 'MAVEN3' // Ensure the name matches the Maven version configured in Jenkins
        jdk 'OpenJDK-11'    // Make sure JDK name matches the configured JDK
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-repo.git', branch: 'master'
            }
        }


        stage('Build') {
            steps {
                bat 'mvn clean install' // Using bat instead of sh
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test' // Using bat instead of sh
                junit 'target/surefire-reports/*.xml'
                jacoco(execPattern: 'target/jacoco.exec')
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
    }
}
