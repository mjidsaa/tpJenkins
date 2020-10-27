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
                                configFileProvider([configFile(fileId: 'maven-config', variable: 'MAVEN_SETTINGS_XML')]) {
                                    sh "mvn deploy -s $MAVEN_SETTINGS_XML"
                                }
                            }
                        }
    }
}