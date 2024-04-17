pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    allure includeProperties: false,
                           jdk: '',
                           results: [[path: 'build/allure-results']]
                }
                    post {
                        always {
                            archiveArtifacts artifacts: 'allure-results/*.html'
                        }
                    }
            }
        }
    }
}
