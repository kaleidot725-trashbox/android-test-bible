package kaleidot725.tests.rxjava.list3_34_37

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.Test
import java.util.concurrent.TimeUnit

class SimpleObservableTest {
    val observable = Observable.just("Rx").delay(1, TimeUnit.SECONDS)
    val listObservable: Observable<String> = listOf("Giants", "Dodgers", "athletics")
        .toObservable()
        .delay(1, TimeUnit.SECONDS)

    @Test
    fun observabletestNoGood() {
        observable.subscribeBy(onNext = {
            System.out.println(it)
            assertThat(it).isEqualTo("Rx")
        })
    }

    @Test
    fun observableTestGood() {
        val subscriber = observable.test()
        subscriber.await()
            .assertComplete()
            .assertValue("Rx")
    }

    @Test
    fun observableListSuccess() {
        val teams: List<String> = listObservable.test()
            .await()
            .assertComplete()
            .values()

        assertThat(teams).containsExactly("Giants", "Dodgers", "athletics")
    }

    @Test
    fun observableListError() {
        val errorObservables: Observable<RuntimeException> =
            Observable.error(RuntimeException("Oops!"))

        errorObservables.test()
            .await()
            .assertNotComplete()
            .assertError(RuntimeException::class.java)
            .assertErrorMessage("Oops!")
    }

}