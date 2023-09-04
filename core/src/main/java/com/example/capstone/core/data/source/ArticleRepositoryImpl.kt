package com.example.capstone.core.data.source

import android.provider.ContactsContract.Data
import com.example.capstone.core.data.source.local.LocalDataSource
import com.example.capstone.core.data.source.remote.RemoteDataSource
import com.example.capstone.core.data.source.remote.network.ApiResponse
import com.example.capstone.core.data.source.remote.response.ArticlesItemResponse
import com.example.capstone.core.domain.models.ArticlesItem
import com.example.capstone.core.domain.repository.ArticleRepository
import com.example.capstone.core.utils.AppExecutors
import com.example.capstone.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : ArticleRepository {
    override fun getAllArticle(): Flow<Resource<List<ArticlesItem>>> {
        return object : NetworkBoundResource<List<ArticlesItem>, List<ArticlesItemResponse>>() {
            override fun loadFromDB(): Flow<List<ArticlesItem>> {
                return localDataSource.getAllArticle().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ArticlesItemResponse>>> =
                remoteDataSource.getAllNews()

            override suspend fun saveCallResult(data: List<ArticlesItemResponse>) {
                val articleList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertArticle(articleList)
            }

            override fun shouldFetch(data: List<ArticlesItem>?): Boolean =
                true

        }.asFlow()
    }

    override fun getFavoriteArticle(): Flow<List<ArticlesItem>> {
        return localDataSource.getFavoriteArticle().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteArticle(article: ArticlesItem, state: Boolean) {
        val articleEntity = DataMapper.mapDomainToEntity(article)
        appExecutors.diskIO().execute{ localDataSource.setFavoriteArticle(articleEntity, state)}
    }

}