pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'git@github.com:pulkitgo/Calculator.git'
            }post {
                failure {
                    mail bcc: '', body: 'pipeline failed at clone repository stage', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline failed', to: 'pulkitg666@gmail.com'
                }
            }
        }
        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
            post{
                failure {
                    mail bcc: '', body: 'pipeline failed at Build maven project stage', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline failed', to: 'pulkitg666@gmail.com'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t mt2025096/scientific-calculator .'
            }
            post{
                failure {
                    mail bcc: '', body: 'pipeline failed at Docker image build stage', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline failed ', to: 'pulkitg666@gmail.com'
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh 'docker login -u $USER -p $PASS'
                    sh 'docker push mt2025096/scientific-calculator'
                }
            }
            post{
                failure {
                    mail bcc: '', body: 'pipeline failed at push docker image', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline failed ', to: 'pulkitg666@gmail.com'
                }
            }
        }
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i ansible-deploy/inventory ansible-deploy/deploy.yml'
            }
            post{
                failure {
                    mail bcc: '', body: 'pipeline failed at Deploy with ansible stage', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline failed ', to: 'pulkitg666@gmail.com'
                }
            }
        }
    }

    post{
        success {
            mail bcc: '', body: 'pipeline completed all stages successfully', cc: '', from: 'gpulkit07@gmail.com', replyTo: '', subject: 'pipeline successful', to: 'pulkitg666@gmail.com'
        }
    }

}