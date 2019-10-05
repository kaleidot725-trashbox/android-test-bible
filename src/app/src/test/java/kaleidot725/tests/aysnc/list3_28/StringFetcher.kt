package kaleidot725.tests.aysnc.list3_28

open class StringFetcher {
    fun fetch(): String {
        Thread.sleep(1000L)
        return "foo"
    }
}
