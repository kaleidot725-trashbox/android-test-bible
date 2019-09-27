package kaleidot725.tests.junit.list2_2_15

import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.IllegalArgumentException
import org.assertj.core.api.Assertions.*

@RunWith(JUnit4::class)
class  InputCheckerTest {
    lateinit var target: InputChecker

    @Before
    fun setup() {
        target = InputChecker()
    }

    @After
    fun tearDown() { }

    @Test
    fun isValid() {
        val actual = target.isValid("foo")
        assertThat(actual).isTrue()
    }

    @Test
    fun isValid_givenLessThan3_returnFalse() {
        val actual = target.isValid("ab")
        assertThat(actual).isFalse()
    }

    @Test
    fun isValid_givenAlphabetic_returnsTrue() {
        val actual = target.isValid("abc")
        assertThat(actual).isTrue()
    }

    @Test
    fun isValid_givenNumeric_returnsTrue() {
        val actual = target.isValid("123")
        assertThat(actual).isTrue()
    }

    @Test
    fun isValid_givenAlphaNumeric_returnsTrue() {
        val actual = target.isValid("abc123")
        assertThat(actual).isTrue()
    }

    @Test(expected = IllegalArgumentException::class)
    fun insValid_givenNull_throwsIllegalArgumentException() {
        target.isValid(null)
    }

    @Ignore("テスト対象が仮実装なので一時的にスキップ")
    @Test
    fun temporarilySkipThisTest() {
        /* 略 */
    }
}