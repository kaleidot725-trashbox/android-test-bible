package kaleidot725.tests.mvp

import kaleidot725.tests.service.Repo

interface View {
    fun showRepositoryList(list: List<Repo>)
}

interface Presenter {
    fun getRepositoryList(name: String)
}