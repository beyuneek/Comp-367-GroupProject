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
            // Check if there are any Java test source files
            if (fileExists('src\\test\\java')) {
                // If tests exist, run them and generate code coverage report
                bat 'mvn test jacoco:report'
                junit 'target/surefire-reports/*.xml' // Publish JUnit test results
                jacoco(execPattern: 'target/jacoco.exec') // Publish JaCoCo code coverage report
            } else {
                // No tests are found, handle gracefully
                echo 'No test files exist, skipping test execution.'
                // You can still generate an empty JaCoCo report if needed
                bat 'mvn jacoco:report'
                jacoco(execPattern: 'target/jacoco.exec')
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
