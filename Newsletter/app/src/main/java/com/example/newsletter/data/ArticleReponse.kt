package com.example.newsletter.data

import com.example.newsletter.models.Source

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
data class Article(
//        val source: Source,
        val id:Int,
        val name:String,
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String
)