node() {
  stage 'Checkout'
  checkout scm

  stage 'Build'
  env.PATH = "${tool 'Maven 3'}/bin:${env.PATH}"

  try {
    sh "mvn -B -s .settings.xml -Dmaven.test.failure.ignore clean verify"
  } catch(err) {
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    throw err
  }

  step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
  archive '**/target/*.jar'
}
