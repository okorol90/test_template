pipeline {
    agent any

    stages {
        stage('Analyze') {
            steps {
                echo 'analyze'
            }
        }
        stage('Test') {
            steps {
//                 sh 'mvn clean test -Dfile=dataproviders -Ddp=smoke -Dthread=1'
                bat 'mvn clean compile test -Dfile=dataproviders -Ddp=smoke -Dthread=1'
            }
        }
    }
}