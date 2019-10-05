package kaleidot725.tests.aysnc.list3_26_27

open class StringFetcher {
    fun fetch(): String {
        Thread.sleep(1000L)
        return "foo"
    }
}
