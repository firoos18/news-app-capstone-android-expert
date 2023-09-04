package com.example.capstone.core.utils

import com.example.capstone.core.data.source.local.entity.ArticleEntity
import com.example.capstone.core.data.source.remote.response.ArticlesItemResponse
import com.example.capstone.core.domain.models.ArticlesItem

object DataMapper {
    fun mapResponsesToEntities(input: List<ArticlesItemResponse>): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                title = it.title,
                author = it.author,
                description = it.description,
                content = it.content,
                publishedAt = it.publishedAt,
                url = it.url,
                urlToImage = it.urlToImage,
                isFavorite = false,
                articleId = 0
            )
            articleList.add(article)
        }
        return articleList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<ArticlesItem> =
        input.map {
            ArticlesItem(
                title = it.title,
                author = it.author,
                description = it.description,
                content = it.content,
                publishedAt = it.publishedAt,
                url = it.url,
                urlToImage = it.urlToImage,
                isFavorite = it.isFavorite,
                articleId = it.articleId
            )
        }

    fun mapDomainToEntity(input: ArticlesItem) = ArticleEntity(
        title = input.title,
        author = input.author,
        description = input.description,
        content = input.content,
        publishedAt = input.publishedAt,
        url = input.url,
        urlToImage = input.urlToImage,
        isFavorite = input.isFavorite,
        articleId = input.articleId
    )
}