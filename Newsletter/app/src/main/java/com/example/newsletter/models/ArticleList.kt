package com.example.newsletter.models

import com.google.gson.annotations.SerializedName

data class ArticleList (
        @SerializedName("articles")
        val articles: List<Article>
)