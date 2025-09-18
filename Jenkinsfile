pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials') // Cambia el ID
        DOCKER_IMAGE = 'rougev/pedido-backend'
        TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${TAG} backend"
            }
        }
        stage('Push to Docker Hub') {
            steps {
                sh "echo ${DOCKERHUB_CREDENTIALS_PSW} | docker login -u ${DOCKERHUB_CREDENTIALS_USR} --password-stdin"
                sh "docker push ${DOCKER_IMAGE}:${TAG}"
            }
        }
        // stage('Update Helm Chart') {
        //     steps {
        //         script {
        //             sh '''
        //             cd helm-charts
        //             sed -i "s/tag: .*/tag: ${TAG}/" values.yaml
        //             git config user.email "jenkins@local"
        //             git config user.name "Jenkins"
        //             git add values.yaml
        //             git commit -m "Update image tag to ${TAG}"
        //             git push
        //             '''
        //         }
        //     }
        // }
    }
}