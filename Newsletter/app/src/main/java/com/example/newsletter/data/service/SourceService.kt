package com.example.newsletter.data.service

import com.example.newsletter.data.Source

interface SourceService {
    fun getCountrySources(): List<Source>
    fun getCategorieSources():List<Source>
    fun getEditeurSources():List<Source>

}