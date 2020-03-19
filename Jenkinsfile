pipeline {
   agent any

   stages {
      stage('Clone') {
         steps {
      // Get some code from a GitHub repository
          checkout scm
         }
      }
      stage('Build') {
         steps {
            // Run Maven on a Unix agent.
            sh "mvn web3j:generate-sources"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               
               archiveArtifacts 'target/*.jar'
            }
         }
      }
      stage('docker build') {
         sh "docker build -t=dockerfile/nginx ."
      }
        
   }
}
