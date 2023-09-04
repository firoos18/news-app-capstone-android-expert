package com.example.capstone.core.data.source.local.entity

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstone.core.domain.models.Source

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "articleId")
    var articleId : Int,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null,

    @ColumnInfo(name = "author")
    var author: String? = null,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "url")
    var url: String? = null,

    @ColumnInfo(name = "content")
    var content: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean
)
