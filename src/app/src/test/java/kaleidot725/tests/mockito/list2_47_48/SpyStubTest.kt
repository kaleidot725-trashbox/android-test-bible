package kaleidot725.tests.mockito.list2_47_48

import com.nhaarman.mockitokotlin2.*
import org.junit.Test

class SpyStubTest {
    @Test
    fun spystub() {
        val targetClass: TargetClass = spy(TargetClass())
        doReturn("OTHER").whenever(targetClass).fetchOtherThing()

        targetClass.doSomething()
        verify(targetClass).doWithOtherThing(eq("OTHER"))
    }
}