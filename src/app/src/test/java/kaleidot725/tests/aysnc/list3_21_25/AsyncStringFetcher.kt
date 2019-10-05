package kaleidot725.tests.aysnc.list3_21_25

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AsyncStringFetcher(val fetcher: StringFetcher) {
    val executor: ExecutorService = Executors.newCachedThreadPool()

    fun fetchAsync(
        onSuccess: (value: String) -> Unit,
        onFailure: (error: Throwable) -> Unit
    ) {
        executor.submit {
            try {
                val value = fetcher.fetch()
                onSuccess(value)
            } catch (error: Throwable) {
                onFailure(error)
            }
        }
    }
}