package kaleidot725.tests.rxjava.list3_38_43

import io.reactivex.Single
import java.util.concurrent.Executor
import java.util.concurrent.Executors

data class Tweet(val tweet: String, val id: Int)

class TweetRepository {
    val executor: Executor = Executors.newSingleThreadExecutor()

    fun recents(): Single<List<Tweet>> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val tweets = listOf(Tweet("hello", 1), Tweet("from", 2), Tweet("world", 3))
                    emitter.onSuccess(tweets)
                } catch (error: Throwable) {
                    emitter.onError(error)
                }
            }
        }
    }
}