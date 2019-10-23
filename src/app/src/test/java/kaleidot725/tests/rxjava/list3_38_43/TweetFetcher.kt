package kaleidot725.tests.rxjava.list3_38_43

import io.reactivex.Scheduler
import io.reactivex.rxkotlin.subscribeBy

class TweetFetcher(
    val subscribeScheduler: Scheduler,
    val observeScheduler: Scheduler,
    val repository: TweetRepository
) {
    fun recents(onSuccess: (List<Tweet>) -> Unit, onError: (Throwable) -> Unit) {
        repository.recents()
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)
            .subscribeBy(
                onSuccess = onSuccess,
                onError = onError
            )
    }
}