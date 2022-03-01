pipeline {

  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos'
    gradle 'Gradle6.0.1_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
				credentialsId: 'GitHub_JeissonRangel',
				url:'https://github.com/JeissonRangel/alquilerMotocicletasADN'
			]]
		])
      }
    }

    stage('Clean') {
      steps{
        echo "------------>Clean<------------"
	    dir("microservicio") {
            sh 'chmod +x ./gradlew'
            sh './gradlew --b ./build.gradle clean'
	    }
      }
    }

    stage('Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
	    dir("microservicio") {
            sh 'chmod +x ./gradlew'
            sh './gradlew --b ./build.gradle clean'
            sh './gradlew --b ./build.gradle test'
            sh './gradlew --b ./build.gradle jacocoTestReport'
	    }
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
		withSonarQubeEnv('Sonar') {
		    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
	    dir("microservicio") {
	        sh './gradlew --b ./build.gradle test'
	    }
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }

    success {
      echo 'This will run only if successful'
    }

    failure {
      echo 'This will run only if failed'
      mail (to: 'jeisson.rangel@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
  }
}