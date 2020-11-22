package com.example.newsletter.data.service

import com.example.newsletter.data.Article
import com.example.newsletter.data.Source
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleOnlineService : ArticleService, SourceService {
    private val service: RetrofitApiService

    init {
        val retrofit = buildClient()
        //Init the api service with retrofit
        service = retrofit.create(RetrofitApiService::class.java)
    }

    /**
     * Configure retrofit
     */
    private fun buildClient(): Retrofit {
        val httpClient = OkHttpClient.Builder().apply {
            addLogInterceptor(this)
            addApiInterceptor(this)
        }.build()
        return Retrofit
                .Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
    }

    /**
     * Add a logger to the client so that we log every request
     */
    private fun addLogInterceptor(builder: OkHttpClient.Builder) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        builder.addNetworkInterceptor(httpLoggingInterceptor)
    }

    /**
     * Intercept every request to the API and automatically add
     * the api key as query parameter
     */
    private fun addApiInterceptor(builder: OkHttpClient.Builder) {
        builder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val originalHttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", apiKey)
                        .build()

                val requestBuilder = original.newBuilder()
                        .url(url)
                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        })
    }

    override fun getArticles(): List<Article> {
        return service.list().execute().body()?.articles ?: listOf()
    }
    override fun getCountrySources() : List<Source> {
        return service.sourceCountrylist().execute().body()?.sources?: listOf()
    }

    override fun getCategorieSources():List<Source>{
        return service.sourceCategorielist().execute().body()?.sources?: listOf()
    }
    override fun getEditeurSources():List<Source>{
        return service.sourceEditeurlist().execute().body()?.sources?: listOf()
    }
    companion object {
        private const val apiKey = "951965d5688e4f39a2480cc419856226"
        private const val apiUrl = "http://newsapi.org"
    }

}
