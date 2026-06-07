pipeline {
    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    environment {
        // Set in Jenkins global tools and credentials
        MAVEN_HOME = tool 'Maven-3.9.11'
        PATH = "${env.MAVEN_HOME}/bin;${env.PATH}"
        SONARQUBE_SERVER = 'SonarQube'
        SONAR_PROJECT_KEY = 'jenkins-nexus-cicd'
        SONAR_PROJECT_NAME = 'jenkins-nexus-cicd'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: false
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    bat "mvn -B sonar:sonar -Dsonar.projectKey=${SONAR_PROJECT_KEY} -Dsonar.projectName=${SONAR_PROJECT_NAME}"
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Package') {
            steps {
                bat 'mvn -B -DskipTests package'
            }
        }

        stage('Deploy To Nexus') {
            when {
                anyOf {
                    branch 'main'
                    branch 'master'
                }
            }
            steps {
                // Requires ~/.m2/settings.xml with nexus-releases and nexus-snapshots servers.
                bat 'mvn -B -DskipTests deploy'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check stage logs and fix before re-running.'
        }
    }
}
