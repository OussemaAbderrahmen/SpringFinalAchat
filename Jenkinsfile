pipeline {
    agent any

   

    stages {
        stage('Git') {
            steps {
            
                git branch: 'main', url: 'https://github.com/OussemaAbderrahmen/SpringFinalAchat.git',
                credentialsId : '33c04f0b-acb3-488e-80de-00a29b1c504f	'
                
            }

           
        }
        stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
            }
        }
        
        stage("MVN Clean"){
            steps {
                sh """mvn clean """
                
            }
        }

        stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }
        
        
    }

}