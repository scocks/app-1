pipeline {
   agent {
        kubernetes {
            cloud 'kubernetes'
            label 'mypod'
            yaml """
                apiVersion: v1
                kind: Pod
                spec:
                  containers:
                    - name: jdk17
                      image: openjdk:17-jdk
                      command: ['cat']
                      tty: true
            """
        }
    }
    stages {
        stage('Clone Repo') {
            steps {
                git (url: "git@github.com:scocks/app-1.git", credentialsId: "scocks", branch: "main")
            }
        }
        stage('Build and Test') {
            steps {
                container('jdk17') {                                        
                    sh """
                    ./gradlew clean build test
                    """                    
                }
            }
        }
        stage('Sonar') {
            steps {
                container('jdk17') {                    
                    sh """
                    ./gradlew sonar
                    """
                }
            }
        }
        stage('Run') {
            steps {
                container('jdk17') {                    
                    sh """
                    ./gradlew run
                    """
                }
            }
        }
    }
}
