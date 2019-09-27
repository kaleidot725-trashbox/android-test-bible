package kaleidot725.tests.junit.list2_19

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class IterableCollectionAssertionTest {
    @Test
    fun iterableCollectionAssert() {
        val target = listOf("Giants", "Dodgers", "Athletics")

        assertThat(target)
            .hasSize(3)
            .contains("Dodgers")
            .containsOnly("Athletics", "Dodgers", "Giants")
            .containsExactly("Giants", "Dodgers", "Athletics")
            .doesNotContain("Padres")
    }
}