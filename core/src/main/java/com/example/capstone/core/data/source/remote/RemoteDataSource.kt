package com.example.capstone.core.data.source.remote

import android.util.Log
import com.example.capstone.core.data.source.remote.network.ApiResponse
import com.example.capstone.core.data.source.remote.network.ApiService
import com.example.capstone.core.data.source.remote.response.ArticlesItemResponse
import com.example.capstone.core.utils.apiKey
import com.example.capstone.core.utils.country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService : ApiService) {

    suspend fun getAllNews() : Flow<ApiResponse<List<ArticlesItemResponse>>> {
        return flow {
            try {
                val response = apiService.getArticle(apiKey = apiKey, country = country)
                val dataArray = response.articles
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.articles))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}