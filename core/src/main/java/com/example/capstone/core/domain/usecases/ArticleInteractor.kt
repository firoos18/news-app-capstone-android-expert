package com.example.capstone.core.domain.usecases

import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.models.ArticlesItem
import com.example.capstone.core.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticleInteractor(private val articleRepository: ArticleRepository) : ArticleUseCase {
    override fun getAllArticle(): Flow<Resource<List<ArticlesItem>>> = articleRepository.getAllArticle()

    override fun getFavoriteArticle(): Flow<List<ArticlesItem>>  = articleRepository.getFavoriteArticle()

    override fun setFavoriteArticle(article: ArticlesItem, state: Boolean) = articleRepository.setFavoriteArticle(article, state)

}