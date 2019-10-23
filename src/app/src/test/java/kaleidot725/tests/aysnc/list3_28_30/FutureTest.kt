package kaleidot725.tests.aysnc.list3_28_30

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.concurrent.CountDownLatch

class FutureTest {
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
    fun fetchAsync_future_OK() {
        var actualValue: String? = null
        var actualError: Throwable? = null

        asyncFetcher.fetchAsync(
            { value -> actualValue = value },
            { error -> actualError = error }
        ).get()

        verify(fetcher, times(1)).fetch()
        assertThat(actualValue).isEqualTo("foo")
        assertThat(actualError).isNull()
    }

    @Test
    fun fetchAsync_future_NG() {
        doThrow(RuntimeException("ERROR")).whenever(fetcher).fetch()

        var actualValue: String? = null
        var actualError: Throwable? = null

        asyncFetcher.fetchAsync(
            { value -> actualValue = value },
            { error -> actualError = error }
        ).get()

        verify(fetcher, times(1)).fetch()
        assertThat(actualValue).isNull()
        assertThat(actualError)
            .isExactlyInstanceOf(RuntimeException::class.java)
            .hasMessage("ERROR")
    }
}