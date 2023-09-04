package com.example.capstone.core.data.source.local

import com.example.capstone.core.data.source.local.entity.ArticleEntity
import com.example.capstone.core.data.source.local.room.ArticleDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val articleDao: ArticleDao) {

    fun getAllArticle() : Flow<List<ArticleEntity>> = articleDao.getAllArticle()

    fun getFavoriteArticle() : Flow<List<ArticleEntity>> = articleDao.getFavoriteArticle()

    suspend fun insertArticle(articleList : List<ArticleEntity>) = articleDao.insertArticle(articleList)

    fun setFavoriteArticle(article : ArticleEntity, newState : Boolean) {
        article.isFavorite = newState
        articleDao.updateFavoriteArticle(article)
    }
}