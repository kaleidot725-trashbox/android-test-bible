package kaleidot725.tests.aysnc.list3_26_27

import com.nhaarman.mockitokotlin2.*
import kaleidot725.tests.aysnc.list3_21_25.AsyncStringFetcher
import kaleidot725.tests.aysnc.list3_21_25.StringFetcher
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class CountDownLatchTest {
    lateinit var fetcher: StringFetcher
    lateinit var asyncFetcher: AsyncStringFetcher
    lateinit var latch: CountDownLatch

    @Before
    fun setUp() {
        latch = CountDownLatch(1)
        fetcher = spy()
        asyncFetcher = AsyncStringFetcher(fetcher)
    }

    @Test
    fun fetchAsync_callbackedProperly() {
        asyncFetcher.fetchAsync(
            { value ->
                assertThat(value).isEqualTo("foo")
                verify(fetcher, times(1)).fetch()
                System.out.println("success")
                latch.countDown()
            },
            { _ -> }
        )

        System.out.println("fetchAsync invoked.")
        latch.await()
    }

    @Test
    fun fetchAsync_error() {
        doThrow(RuntimeException("ERROR")).whenever(fetcher).fetch()
        asyncFetcher.fetchAsync(
            { _ -> },
            { error ->
                assertThat(error)
                    .isInstanceOf(RuntimeException::class.java)
                    .hasMessageContaining("ERROR")
                verify(fetcher, times(1)).fetch()
                System.out.println("failure")
                latch.countDown()
            }
        )

        System.out.println("fetchAsync invoked")
        latch.await()
    }
}