package com.example.newsletter.data.service

import com.example.newsletter.data.Article


interface ArticleService{
    fun getArticles(): List<Article>
    fun getCountryArticle(query: String) : List<Article>
    fun getCategorieArticle(query: String):List<Article>
    fun getEditeurArticle(query: String):List<Article>
}