pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                 git branch: 'develop', "https://github.com/okorol90/test_template.git"
            }
        }
        stage('Analyze') {
            steps {
                echo 'analyze'
            }
        }
        stage('Test') {
            steps {
//                 sh 'mvn clean test -Dfile=dataproviders -Ddp=smoke -Dthread=1'
                bat 'mvn clean test -Dfile=dataproviders -Ddp=smoke -Dthread=1'
            }
        }
    }
}