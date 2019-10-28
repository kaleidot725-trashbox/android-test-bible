package kaleidot725.tests.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<Repo>>
}

class GitHubRemoteDataSource(val gitHubServicde: GitHubService) {
    fun listRepos(user: String): Single<List<Repo>> {
        return gitHubServicde.listRepos(user)
    }
}

class GitHubRepository(val dataSource: GitHubRemoteDataSource) {
    fun listRepos(user: String): Single<List<Repo>> {
        return dataSource.listRepos(user)
    }
}