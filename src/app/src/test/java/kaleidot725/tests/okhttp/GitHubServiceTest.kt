package kaleidot725.tests.okhttp

import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kaleidot725.tests.service.GitHubRemoteDataSource
import kaleidot725.tests.service.GitHubService
import java.io.BufferedReader
import java.io.InputStreamReader

class GitHubServiceTest {
    val mockWebServer = MockWebServer()
    lateinit var gitHubRemoteDataSource: GitHubRemoteDataSource

    @Before
    fun setup() {
        val dispatcher: Dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest?): MockResponse {
                return when {
                    request == null -> MockResponse().setResponseCode(400)
                    request.path == null -> MockResponse().setResponseCode(400)
                    request.path.matches(Regex("/users/[a-zA-z0-9]+/repos]")) -> {
                        MockResponse().setResponseCode(200).setBodyFromFileName("users_repos.json")
                    }
                    else -> MockResponse().setResponseCode(400)
                }
            }
        }

        mockWebServer.setDispatcher(dispatcher)
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gitHubService = retrofit.create(GitHubService::class.java)
        gitHubRemoteDataSource = GitHubRemoteDataSource(gitHubService)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    fun MockResponse.setBodyFromFileName(name: String): MockResponse {
        val inputStream = javaClass.classLoader.getResourceAsStream(name)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        bufferedReader.forEachLine { buffer -> stringBuilder.append(buffer) }

        val body = stringBuilder.toString()
        this.setBody(body)
        return this
    }

    @Test
    fun getRepository() {
        gitHubRemoteDataSource.listRepos("").test().await().assertNotComplete()
        var list = gitHubRemoteDataSource.listRepos("kaleidot725")
            .test()
            .await()
            .assertNoErrors()
            .assertComplete()
            .values()[0]

        assertThat(list).isNotEmpty
    }
}