package com.example.capstone.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.capstone.core.data.source.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticle() : Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE isFavorite = 1")
    fun getFavoriteArticle() : Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article : List<ArticleEntity>)

    @Update
    fun updateFavoriteArticle(article : ArticleEntity)
}