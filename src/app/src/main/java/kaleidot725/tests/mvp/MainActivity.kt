package kaleidot725.tests.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kaleidot725.tests.R
import kaleidot725.tests.service.GitHubRemoteDataSource
import kaleidot725.tests.service.GitHubRepository
import kaleidot725.tests.service.GitHubService
import kaleidot725.tests.service.Repo
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), View {

    override fun showRepositoryList(list: List<Repo>) {
        // RecyclerViewなどに結果を描画
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val gitHubService = retrofit.create(GitHubService::class.java)
        val gitHubRemoteDataSource = GitHubRemoteDataSource(gitHubService)
        val repository = GitHubRepository(gitHubRemoteDataSource)
        val presenter = ListPresenter(this, repository)
        presenter.getRepositoryList("shiroyama")
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
