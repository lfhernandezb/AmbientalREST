pipeline {
  agent any
  tools {
      jdk 'jdk-8u291-b10'
  }
  stages {
    stage('build') {
      steps {
        withGradle() {
          sh './gradlew build'
        }

      }
    }

  }
}
