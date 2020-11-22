package com.example.newsletter.data.service

import com.example.newsletter.data.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiService
{
//&from=2020-10-22
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/v2/everything?q=bitcoin&sortBy=publishedAt")
//    fun list(): Call<List<Article>>
    fun list(): Call<ArticleResponse>


}