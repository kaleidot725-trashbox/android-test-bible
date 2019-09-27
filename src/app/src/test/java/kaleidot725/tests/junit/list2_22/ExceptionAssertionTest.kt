package kaleidot725.tests.junit.list2_22

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test
import java.lang.RuntimeException

class ExceptionAssertionTest {
    @Test
    fun exceptionAssert() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { functionMayThrow() }
            .withMessage("Aborted!")
            .withNoCause()
    }

    fun functionMayThrow() {
        throw RuntimeException("Aborted!")
    }
}