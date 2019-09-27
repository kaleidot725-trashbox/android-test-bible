package kaleidot725.tests.junit.list2_1

import org.junit.Test

class AssertTest {
    @Test
    fun assert() {
        assert(1 + 1 == 2)
        assert("foo" + "bar" == "foobar")
    }
}

