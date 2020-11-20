package com.example.newsletter.data

import com.example.newsletter.models.Article

class ArticleRepository {
    private val apiService: ArticleResponse

    init {
        apiService = RetrofitApiService
    }

    fun getArticles(): List<Article> = apiService.articles
        companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}