package com.example.newsletter.models

import com.example.newsletter.data.Article
import com.google.gson.annotations.SerializedName

data class ArticleList (
        @SerializedName("articles")
        val articles: List<Article>
)