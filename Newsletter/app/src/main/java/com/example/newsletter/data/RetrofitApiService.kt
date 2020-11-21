package com.example.newsletter.data

import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleList
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiService
{
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/v2/everything?q=bitcoin&from=2020-10-21&sortBy=publishedAt")
//    fun list(): Call<List<Article>>
    fun list(): Call<ArticleList>


}