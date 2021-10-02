def buildNumber = env.BUILD_NUMBER as int
if (buildNumber > 1) milestone(buildNumber - 1)
milestone(buildNumber)

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                echo '>>>>>>>>>>>>>>Building>>>>>>>>'
                // // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                 echo '>>>>>>>>>>>>>>Jenkins is the Best>>>>>>>>'+buildNumber
            }
        }
        stage('Run') {
            steps{
                 echo '>>>>>>>>>>>>>>Running>>>>>>>>'
                 sh "mvn spring-boot:run"
            }
        }
    }
}


