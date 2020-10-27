/**
 * Jenkins settings
 */
mavenSettingsConfig = 'GCS-settings'
npmRcRelease = 'gcm-release-config'
gitCredentialsId = 'd935d29c-a006-45ec-b448-28e0743992db'

def nexusDockerSnapshot = 'nexus.amplexor.com:8189'
def nexusDockerRelease = 'nexus.amplexor.com:8188'

def dev2DockerServer = 'lu01du-gcs-cont.com.euroscript.local'

def appName = ''
def appVersion = ''

def releaseVersion = ''
def deployVersion = false
def performRelease = false

pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage ('Test') {
                    steps {
                        sh 'mvn test'
                    }
                }
         stage ('Deploy') {
                            steps {
                                sh 'mvn deploy'
                            }
                        }
    }
}