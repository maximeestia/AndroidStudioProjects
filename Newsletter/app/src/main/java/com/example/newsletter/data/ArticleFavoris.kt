package com.example.newsletter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.newsletter.models.Source
import java.util.*

@Entity(
    tableName = "article_favoris",
    indices = [Index("article_favoris_id")]
)

data class ArticleFavoris(
    @ColumnInfo(name = "Source") val source :Source,
    @ColumnInfo(name = "Author") val author :String,
    @ColumnInfo(name = "Title") val title :String,
    @ColumnInfo(name = "Description") val description :String,
    @ColumnInfo(name = "Url") val url :String,
    @ColumnInfo(name = "Urltoimage") val urltoimage :String,
    @ColumnInfo(name = "publishedAt") val publishedAt: String,
    @ColumnInfo(name = "Content") val content :String,
    @ColumnInfo(name = "Favoris") val articleFavoris: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0
}