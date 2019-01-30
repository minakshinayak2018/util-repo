def notifyBuild()
{
  def subject = "${env.BUILD_STATUS}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>
    <p>Please give input to deploy"<a href="${env.JENKINS_URL}/job/${env.JOB_NAME}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>"""
	
 emailext (
      attachLog: true,
      compressLog: true,	 
      subject: subject,
      body: details,
      to: commonProps.recipients
    )
  }
   def checkOutRepo(String repo, branch, String credentials){
    git repo,branch,credentials
}

return this
