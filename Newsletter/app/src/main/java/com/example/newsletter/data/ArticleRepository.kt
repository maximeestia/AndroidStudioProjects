package com.example.newsletter.data

import com.example.newsletter.data.service.ArticleOnlineService

class ArticleRepository(query: String) {
    private val apiService: ArticleOnlineService = ArticleOnlineService(query)

    fun getArticles(): List<Article> = apiService.getArticles()
    fun getCountryArticle(query:String): List<Article> = apiService.getCountryArticle(query)
    fun getCategorieArticle(query:String): List<Article> = apiService.getCategorieArticle(query)
    fun getEditeurArticle(query:String): List<Article> = apiService.getEditeurArticle(query)


    companion object {
        private var instance: ArticleRepository? = null

        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository("all")
            }
            return instance!!
        }
    }
}