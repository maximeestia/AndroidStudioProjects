package com.example.newsletter.data

import com.example.newsletter.models.Article

interface ArticleService {
    fun getArticles(): List<Article>
}