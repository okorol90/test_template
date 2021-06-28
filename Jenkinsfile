pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                git "https://github.com/okorol90/test_template.git"
            }
        }
    stages {
        stage('Analyze') {
             steps {
                echo "analyze"
            }
        }
    }
    stages {
        stage('Analyze') {
             steps {
                sh "mvn clean test -Dfile=dataproviders -Ddp=smoke -Dthread=1"
             }
        }
    }
}