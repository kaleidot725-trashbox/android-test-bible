package kaleidot725.tests.aysnc.list3_21_25

import com.nhaarman.mockitokotlin2.spy
import org.assertj.core.api.Assertions.fail
import org.junit.Before
import org.junit.Test

class AsyncFetcherTest {
    lateinit var fetcher: StringFetcher
    lateinit var asyncFetcher: AsyncStringFetcher

    @Before
    fun setUp() {
        fetcher = spy()
        asyncFetcher = AsyncStringFetcher(fetcher)
    }

    @Test(expected = RuntimeException::class)
    fun fetchAsync_expectFailButPass_01() {
        asyncFetcher.fetchAsync(
            { _ -> fail("onSuccess") },
            { _ -> fail("onFailure") }
        )
        Thread.sleep(2000L)
    }
}