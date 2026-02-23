// This DSL script defines the job that uses the pipeline from jenkins/pipelines/ci-pipeline.jenkinsfile

pipelineJob('example-ci-pipeline') {
    description('Continuous Integration Pipeline')
    
    parameters {
        stringParam('BRANCH_NAME', 'main', 'Branch to build')
        booleanParam('RUN_TESTS', true, 'Run unit tests')
    }

    definition {
        cps {
            // Reads the Jenkinsfile from the Seed Job's workspace and embeds it directly
            script(readFileFromWorkspace('jenkins/pipelines/ci-pipeline.jenkinsfile'))
            sandbox()
        }
    }
}
