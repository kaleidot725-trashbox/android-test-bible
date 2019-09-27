package kaleidot725.tests.mockito.list2_49_50

open class OtherThingFetcher {
    open fun fetchOtherThing(): String {
        return ""
    }
}

open class OtherThingHandler {
    open fun doWithOtherThing(text: String) {

    }
}

open class TargetClass(
    val fetcher: OtherThingFetcher,
    val handler: OtherThingHandler
) {
    open fun doSomething() {
        val text = fetcher.fetchOtherThing()
        handler.doWithOtherThing(text)
    }
}
