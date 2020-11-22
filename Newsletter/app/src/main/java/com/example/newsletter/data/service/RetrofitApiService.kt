package com.example.newsletter.data.service

import com.example.newsletter.data.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService
{
//&from=2020-10-22
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/v2/top-headlines?country=fr")
    fun list(): Call<ArticleResponse>

    @GET("/v2/top-headlines")
    fun sourceCountrylist(
            @Query("country")country:String):Call<ArticleResponse>

    @GET("/v2/top-headlines")
    fun sourceCategorielist(
            @Query("category") category:String):Call<ArticleResponse>
    @GET("/v2/top-headlines")
    fun sourceEditeurlist(
            @Query("sources")sources:String):Call<ArticleResponse>
}
