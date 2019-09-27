package kaleidot725.tests.mockito.list2_47_48

open class TargetClass {
    open fun doSomething() {
        val text = fetchOtherThing()
        doWithOtherThing(text)
    }

    open fun fetchOtherThing(): String {
        return ""
    }

    open fun doWithOtherThing(text: String) {
    }
}