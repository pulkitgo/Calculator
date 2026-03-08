pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Use the SSH URL if Jenkins has the SSH key configured
                git branch: 'main', url: 'git@github.com:pulkitgo/Calculator.git'
            }
            post {
                failure {
                    mail(
                        to: 'pulkitg666@gmail.com',
                        from: 'gpulkit07@gmail.com',
                        subject: 'Pipeline failed: Clone Repository',
                        body: 'Pipeline failed at Clone Repository stage'
                    )
                }
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
            post {
                failure {
                    mail(
                        to: 'pulkitg666@gmail.com',
                        from: 'gpulkit07@gmail.com',
                        subject: 'Pipeline failed: Build Maven Project',
                        body: 'Pipeline failed at Build Maven Project stage'
                    )
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t mt2025096/scientific-calculator .'
            }
            post {
                failure {
                    mail(
                        to: 'pulkitg666@gmail.com',
                        from: 'gpulkit07@gmail.com',
                        subject: 'Pipeline failed: Build Docker Image',
                        body: 'Pipeline failed at Docker image build stage'
                    )
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'docker login -u $USER -p $PASS'
                    sh 'docker push mt2025096/scientific-calculator'
                }
            }
            post {
                failure {
                    mail(
                        to: 'pulkitg666@gmail.com',
                        from: 'gpulkit07@gmail.com',
                        subject: 'Pipeline failed: Push Docker Image',
                        body: 'Pipeline failed at Push Docker Image stage'
                    )
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i ansible-deploy/inventory ansible-deploy/deploy.yml'
            }
            post {
                failure {
                    mail(
                        to: 'pulkitg666@gmail.com',
                        from: 'gpulkit07@gmail.com',
                        subject: 'Pipeline failed: Deploy with Ansible',
                        body: 'Pipeline failed at Deploy with Ansible stage'
                    )
                }
            }
        }
    }

    post {
        success {
            mail(
                to: 'pulkitg666@gmail.com',
                from: 'gpulkit07@gmail.com',
                subject: 'Pipeline successful',
                body: 'Pipeline completed all stages successfully'
            )
        }
    }
}