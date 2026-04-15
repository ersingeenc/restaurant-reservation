pipeline {
    agent any

    stages {
        stage('Kodlari Cek') {
            steps {
                git branch: 'main', url: 'https://github.com/ersingeenc/restaurant-reservation.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t restaurant-reservation .'
            }
        }

        stage('Container Temizle') {
            steps {
                bat 'docker rm -f restaurant-reservation-container || exit 0'
            }
        }

        stage('Container Calistir') {
            steps {
                bat 'docker run -d -p 8081:8081 --name restaurant-reservation-container restaurant-reservation'
            }
        }
    }
}