multibranchPipelineJob('spring-boot-java-11') {
    branchSources {
        git {
            remote('https://github.com/sharadprsn/spring-boot-java-11.git')
            credentialsId('github-credential')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
    triggers {
        periodic(5)
    }
}