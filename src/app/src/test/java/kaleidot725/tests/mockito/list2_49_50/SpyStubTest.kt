package kaleidot725.tests.mockito.list2_49_50

import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class SpyStubTest {
    @Test
    fun spystub() {
        val fetcher: OtherThingFetcher = mock()
        whenever(fetcher.fetchOtherThing()).thenReturn("OTHER")

        val handler: OtherThingHandler = mock()
        val targetClass = TargetClass(fetcher, handler)

        targetClass.doSomething()
        verify(handler).doWithOtherThing(eq("OTHER"))
    }
}