package kaleidot725.tests.junit.list2_16

import org.assertj.core.api.Assertions
import org.junit.Test

class AssertJTest {

    @Test
    fun assertj() {
        Assertions.assertThat("TOKYO")
            .`as`("TEXT CHECK TOKYO")
            .isEqualTo("TOKYO")
            .isEqualToIgnoringCase("tokyo")
            .isNotEqualTo("KYOTO")
            .isNotBlank()
            .startsWith("TO")
            .endsWith("YO")
            .contains("OKY")
            .matches("[A-Z]{5}")
            .isInstanceOf(String::class.java)
    }
}