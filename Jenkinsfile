/**
 * Jenkins settings
 */
pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk11'
    }
    parameters {
        booleanParam(name: "Perform release ?", description: '', defaultValue: false)
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
            when { expression {  params['Perform release ?']} }
            steps {
                withCredentials([usernamePassword(credentialsId: 'mjidsaa', passwordVariable: 'PASSWORD_VAR', usernameVariable: 'USERNAME_VAR')]){
                    withMaven(mavenSettingsConfig: 'maven-config', globalMavenSettingsConfig: 'global-config') {
                        sh 'git config --global user.email "you@example.com"'
                        sh 'git config --global user.name "Test"'
                        sh 'mvn release:prepare -s C:/Users/Majid/.m2/settings.xml -B -Dusername="mjidsaa" -Dpassword="lalunerougeLAM1986:"'
                        sh 'mvn release:perform -s C:/Users/Majid/.m2/settings.xml -B -Dusername="mjidsaa" -Dpassword="lalunerougeLAM1986:"'
                    }
                }
            }
        }
        stage('Sonar') {
            steps {
                sh "mvn  -s C:/Users/Majid/.m2/settings.xml sonar:sonar"
            }
        }
    }
}