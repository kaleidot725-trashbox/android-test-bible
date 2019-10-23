package kaleidot725.tests.aysnc.list3_28_30

open class StringFetcher {
    open fun fetch(): String {
        Thread.sleep(1000L)
        return "foo"
    }
}
