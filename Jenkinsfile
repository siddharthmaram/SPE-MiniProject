pipeline {
    agent any
    environment {
        DOCKER_CREDS_ID = 'dockerhub-creds'
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
                sh "docker build -t siddharthmaram/spe-miniproject:latest ."
            }
        }

        stage ('Login and Push Image to DockerHub')
        {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDS_ID, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                        sh "docker push ${DOCKER_USERNAME}/spe-miniproject:latest"
                    }
                }
            }
        }

        stage ('Deploy')
        {
            steps {
                script {
                    sh 'ansible-playbook -i inventory.ini playbook.yml'
                }
            }
        }

    }
}