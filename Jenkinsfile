pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent {
                label "master"
            }
			tools {
    maven 'mymaven'
  }
  
	

    stages {
        stage('Prerequisite Check') {
            steps {
               script {
                   def BUILD_BRANCH = env.BRANCH_NAME
                   def BUILD_BRANCH_TYPE = null
                   def BUILD_BRANCH_TASK = null
                   def BUILD_SHA1 = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                   def BUILD_TAG = sh(script: "git tag -l --points-at HEAD", returnStdout: true).trim()
                   def BUILD_TYPE = null
                   def BUILD_VERSION = null
                   def matcher = BUILD_BRANCH =~ /(.*)\/(.*)/
                   def TAG_VERSION = BUILD_TAG.split( '-' )
                   env.BUILD_BRANCH = BUILD_BRANCH
                   env.BUILD_BRANCH_TYPE = BUILD_BRANCH_TYPE
                   env.BUILD_BRANCH_TASK = BUILD_BRANCH_TASK
                   env.BUILD_SHA1 = BUILD_SHA1
                   env.BUILD_TAG = BUILD_TAG
                   env.BUILD_VERSION = BUILD_VERSION
                   env.BUILD_TYPE = BUILD_TYPE
			   }
            }
        }
        stage('Initialize') {
            steps {
                echo 'Hello, Maven'
                sh 'java -version'
            }
        }
        stage('Code Compilation') {
            steps {
                echo 'Hello, Maven'
                sh 'mvn clean package'
            }
        }
        stage('Sonar Inspection') {
            steps {
                echo 'Hello, Maven'
                sh 'java -version'
            }
        }
        stage('QA Code Testing') {
            steps {
                echo 'Hello, Maven'
                sh 'java -version'
            }
        }
	    stage('dockerfile creation')
	    {
		    steps{
			    sh '/opt/dir.sh'
		    	}
	    }
        stage('Build Docker Image') {
            steps {
                 sh ' docker build -t zerodowntime . '
            }
        }
        stage('Upload Docker Image to AWS ECR') {
            steps {
			   script {
			      withDockerRegistry([credentialsId:'ecr:ap-south-1:a5b6a33b-fd3a-49d2-a9f0-22c9cbd15bd6', url:"721716452998.dkr.ecr.ap-south-1.amazonaws.com/zerodowntime"]){
                  sh """
				  echo "Tagging the Docker Image: In Progress"
				  docker tag zerodowntime:latest 721716452998.dkr.ecr.ap-south-1.amazonaws.com/zerodowntime:zerodowntime
				  echo "Tagging the Docker Image: Completed"
				  echo "Push Docker Image to ECR : In Progress"
				  docker push 721716452998.dkr.ecr.ap-south-1.amazonaws.com/zerodowntime:latest
				  echo "Push Docker Image to ECR : Completed"
				  """
				  }
                }
            }
		}
		
		
		
        stage('Deploy to Prod') {
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}
