package com.example.newsletter.data

import com.example.newsletter.data.service.ArticleOnlineService

class SourcesRepository {private val apiService: ArticleOnlineService = ArticleOnlineService()

    fun getCountrySources(): List<Source> = apiService.getCountrySources()
    fun getCategorieSources():List<Source> =apiService.getCategorieSources()
    fun getEditeurSources():List<Source> = apiService.getEditeurSources()

    companion object {
        private var instance: SourcesRepository? = null
        fun getInstance(): SourcesRepository {
            if (instance == null) {
                instance = SourcesRepository()
            }
            return instance!!
        }
    }
}