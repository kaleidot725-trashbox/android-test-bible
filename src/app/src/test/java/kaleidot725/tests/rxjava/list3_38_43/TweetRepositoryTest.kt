package kaleidot725.tests.rxjava.list3_38_43

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class TweetRepositoryTest {
    @Test
    fun getRecents() {
        val repository = TweetRepository()
        val list = repository.recents()
            .test()
            .await()
            .values()[0]

        assertThat(list)
            .extracting("tweet", String::class.java)
            .containsExactly("hello", "from", "world")
    }

    lateinit var repository: TweetRepository
    lateinit var tweetFetcher: TweetFetcher

    @Before
    fun setup() {
        repository = mock(name = "StubTweetRepository")
        val tweets = listOf(Tweet("hello", 1), Tweet("from", 2), Tweet("world", 3))
        whenever(repository.recents()).thenReturn(Single.just(tweets))

        tweetFetcher = TweetFetcher(
            Schedulers.trampoline(),
            Schedulers.trampoline(),
            repository
        )
    }

    @Test
    fun tweetFetcherTest() {
        tweetFetcher.recents(
            onSuccess = {
                assertThat(it)
                    .extracting("tweet", String::class.java)
                    .containsExactly("hello", "from", "world")
            },
            onError = {}
        )
    }
}
