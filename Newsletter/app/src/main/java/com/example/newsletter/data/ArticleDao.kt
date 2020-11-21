package com.example.newsletter.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsletter.models.Article

/**
 * The Data Access Object for the Article class.
 */
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_favoris ORDER BY title")
    fun getArticles(): LiveData<List<Article>>

    @Query("SELECT * FROM article_favoris WHERE favoris = TRUE ORDER BY title")
    fun getArticleFavoris(): LiveData<List<Article>>

    @Query("SELECT * FROM article_favoris WHERE id = :articleId")
    fun getArticle(articleId: String): LiveData<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Article>)
}