package kaleidot725.tests.list2_18

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.Test

class NumberAssertionTest {
    @Test
    fun numberassesrt()
    {
        assertThat(3.14159)
            .isNotZero()
            .isNotNegative()
            .isGreaterThan(3.0)
            .isLessThanOrEqualTo(4.0)
            .isBetween(3.0, 3.2)
            .isCloseTo(Math.PI, within(0.001))
    }
}