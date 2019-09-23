package kaleidot725.tests.list2_17

import org.assertj.core.api.SoftAssertions
import org.junit.Test

class SoftAssertionsTest {
    @Test
    fun softassertions() {
        SoftAssertions().apply {
            assertThat("TOKYO")
                .`as`("TEXT CHECK TOKYO")
                .isEqualTo("HOKKAIDO")
                .isEqualToIgnoringCase("tokyo")
                .isNotEqualTo("KYOTO")
                .isNotBlank()
                .startsWith("TO")
                .endsWith("YO")
                .contains("OKY")
                .matches("[A-Z]{5}")
                .isInstanceOf(String::class.java)
        }.assertAll()
    }
}