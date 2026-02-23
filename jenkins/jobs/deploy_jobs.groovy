// Dynamic Job Creation Example
// Creates multiple jobs based on a list or configuration

def environments = ['dev', 'staging', 'prod']

environments.each { env ->
    pipelineJob("deploy-to-${env}") {
        description("Deploys application to ${env} environment")
        
        parameters {
            stringParam('VERSION', 'latest', 'Version tag to deploy')
            booleanParam('FORCE', false, 'Force deployment')
        }

        definition {
            cps {
                script(readFileFromWorkspace('jenkins/pipelines/deploy.jenkinsfile'))
                sandbox()
            }
        }
    }
}
