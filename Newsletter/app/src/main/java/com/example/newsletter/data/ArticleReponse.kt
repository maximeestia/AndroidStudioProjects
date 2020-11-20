package com.example.newsletter.data

import com.example.newsletter.models.Article

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
