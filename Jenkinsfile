/**
 * Jenkins settings
 */
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
                                withMaven(mavenSettingsConfig: 'maven-config', globalMavenSettingsConfig: 'global-config'){
                                    sh "mvn -X deploy"
                                }
                            }
                        }
    }
}