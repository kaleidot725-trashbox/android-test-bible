package kaleidot725.tests.mockito.list2_45_26

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class listTest {
    @Test
    fun stubPrefix() {
        val list: MutableList<String> = spy(arrayListOf<String>())
        whenever(list[any()]).thenReturn("HELLO")
        assertThat(list[0]).isEqualTo("HELLO")

        doReturn("HELLO").whenever(list)[any()]
        doThrow(RuntimeException()).whenever(list).indexOf(any())
        doNothing().whenever(list).clear()

        doAnswer { invocation ->
            val index = invocation.arguments[0] as Int
            return@doAnswer if (index == 0) "HELLO" else "WORLD"
        }.whenever(list)[any()]
    }
}