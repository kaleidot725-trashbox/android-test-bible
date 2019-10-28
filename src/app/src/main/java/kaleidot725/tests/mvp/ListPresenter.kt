package kaleidot725.tests.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kaleidot725.tests.service.GitHubRepository

class ListPresenter(val view: View, val repository: GitHubRepository) : Presenter {
    override fun getRepositoryList(name: String) {
        repository.listRepos(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { view.showRepositoryList(it) }
    }
}