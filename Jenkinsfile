/**
 * Jenkins settings
 */
pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk11'
    }
    params {
        booleanParam(name: "Perform release ?", description: '', defaultValue: false)
        string(defaultValue: "", description: '', name: 'Release version')
    }
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                withMaven(mavenSettingsConfig: 'maven-config', globalMavenSettingsConfig: 'global-config') {
                    sh "mvn  -s C:/Users/Majid/.m2/settings.xml deploy"
                }
            }
        }
        stage('Release') {
            when { expression { performRelease && releaseVersion != null && releaseVersion != ''} }
            steps {
                withMaven(mavenSettingsConfig: 'maven-config', globalMavenSettingsConfig: 'global-config') {
                    sh "mvn release:prepare -s C:/Users/Majid/.m2/settings.xml"
                    sh "mvn release:perform -s C:/Users/Majid/.m2/settings.xml"
                }
            }
        }
    }
}