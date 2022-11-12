pipeline {
    agent any

   

    stages {
        stage('Git') {
            steps {
            
                git branch: 'ahmed_debbech', url: 'https://github.com/OussemaAbderrahmen/SpringFinalAchat.git',
                credentialsId : '33c04f0b-acb3-488e-80de-00a29b1c504f	'
                
            }

           
        }
        stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
                sh """mvn package -e """
            }
        }

        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """

            }
        }

         stage("MVN Compile"){
            steps {
                sh """mvn compile -e """

            }
        }

        stage("MVN Install"){
            steps {
                sh """mvn install """

            }
        }
        stage('sonar'){
            steps {
                script{ withSonarQubeEnv('sonar') {
                     sh """mvn sonar:sonar -DskipTests"""
                 }

                }
            }
        }
             //stage("Nexus"){
                    //steps {
                   // nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']], credentialsId: 'nexus3', groupId: 'com.esprit.examen', nexusUrl: '1.1.1.12:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nuget-hosted', version: '1.0'

                  //  }
                //}
                stage("Nexus"){
                        steps{
                            script{

                    nexusArtifactUploader artifacts: [
                         [artifactId: 'tpAchatProject',
                                classifier: '',
                                file: "target/tpAchatProject-1.0.jar",
                                 type: 'jar'],
                        ],
                            credentialsId: 'nexus3',
                           groupId: 'com.esprit.examen',
                           nexusUrl: '1.1.1.20:8081',
                           nexusVersion: 'nexus3',
                           protocol: 'http',
                           repository: 'nuget-hosted',
                            version: "1.0"
                        }
                    }
                    }

        
    }

}