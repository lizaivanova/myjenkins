import javaposse.jobdsl.dsl.DslFactory

/**
 * Created by liza.ivanova on 2/28/18.
 */
DslFactory dslFactory = this as DslFactory

dslFactory.freeStyleJob('elasticsearch-create-index-periodically-dsl') {
    displayName "Elastic Search: Create New Index Periodically"
    description "Creates a new index periodically for elastic search"

    triggers {
        cron "H 8 * * 6"
    }

    logRotator 3

    wrappers {
        timestamps()
    }

    steps {
        shell("""${dslFactory.readFileFromWorkspace('scripts/example_a.sh')}""")
    }
}