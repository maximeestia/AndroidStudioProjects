package com.example.newsletter.data

data class SourcesReponse(
        val status: String,
        val sources: List<Source>
)
data class Source(
        val id:Int,
        val name:String,
        val description: String,
        val url: String,
        val category: String,
        val language: String,
        val country: String
)