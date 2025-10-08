pipeline {
    agent any
    triggers { githubPush() }

    environment {
        DOCKER_CREDS_ID = 'dockerhub-creds'
        DOCKER_IMAGE_NAME = 'SPE-MiniProject'
        DOCKERHUB_REPO    = 'siddharthmaram'
    }

    stages {
        stage('Clone Git')
        {
            steps {
                git branch: 'main',
                url: 'https://github.com/siddharthmaram/SPE-MiniProject.git',
                credentialsId: 'github'
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
                sh "docker build -t ${DOCKERHUB_REPO}/${DOCKER_IMAGE_NAME} ."
            }
        }

        stage ('Login and Push Image to DockerHub')
        {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDS_ID, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                        sh "docker push ${DOCKERHUB_REPO}/${DOCKER_IMAGE_NAME}"
                    }
                }
            }
        }

        stage ('Deploy using Ansible')
        {
            steps {
                ansiblePlaybook(playbook: 'playbook.yml', inventory: 'inventory.ini')
            }
        }

    }
}