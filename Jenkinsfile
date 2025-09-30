pipeline {
    agent any
    environment {
        DOCKER_CREDS_ID = 'dockerhub-creds'
    }
    stages {
        stage('Clone Git')
        {
            steps {
                git 'https://github.com/siddharthmaram/SPE-MiniProject.git'
            }
        }

        stage ('Build and Test')
        {
            steps {
                sh "mvn clean package"
            }
        }

        stage ('Create Docker Image')
        {
            steps {
                sh "docker build -t spe-miniproject ."
            }
        }

        stage ('Login and Push Image to DockerHub')
        {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDS_ID, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        / Perform docker login using the retrieved credentials
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"

                        // Example: Build and push a Docker image after successful login
                        sh "docker build -t ${DOCKER_USERNAME}/spe-miniproject:latest ."
                        sh "docker push ${DOCKER_USERNAME}/spe-miniproject:latest"
                    }
                }
            }
        }

    }
}