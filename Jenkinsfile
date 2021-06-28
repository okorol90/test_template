pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                git "https://github.com/okorol90/test_template.git"
            }
        stage('Analyze') {
             steps {
                echo "analyze"
            }
        stage('Analyze') {
             steps {
                sh "mvn clean test -Dfile=dataproviders -Ddp=smoke -Dthread=1"
             }
        }
    }
}