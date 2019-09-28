package kaleidot725.tests.robolectric

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class InputCheckerTest {
    @Test
    fun isValid_givenBlank_throws_throwsIllegalArgumentException() {
        val target = InputChecker()
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { target.isValid("") }
            .withMessage("Cannot be blank")
    }
}