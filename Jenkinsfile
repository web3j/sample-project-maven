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
         steps {
             sh "docker build -t=saijyothi9/nginx ."
         }
      }
       stage('docker push') {
         steps {
             sh "docker push saijyothi9/nginx"
         }
      }
       stage('docker run ') {
         steps {
             sh "docker rm $(docker ps -a -q)"
             sh "docker run --name mynginx1 -p 80:80 -d nginx"
         }
      }
        
   }
}
