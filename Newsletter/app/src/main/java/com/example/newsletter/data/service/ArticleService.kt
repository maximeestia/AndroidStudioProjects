package com.example.newsletter.data.service

import com.example.newsletter.data.Article
import com.example.newsletter.data.Source

interface ArticleService {
    fun getArticles(): List<Article>
    fun getCountryArticle() : List<Article>
    fun getCategorieArticle():List<Article>
    fun getEditeurArticle():List<Article>
}