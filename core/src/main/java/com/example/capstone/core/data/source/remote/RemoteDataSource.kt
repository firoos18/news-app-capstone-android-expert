package com.example.capstone.core.data.source.remote

import android.util.Log
import com.example.capstone.core.data.source.remote.network.ApiResponse
import com.example.capstone.core.data.source.remote.network.ApiService
import com.example.capstone.core.data.source.remote.response.AgentsItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService : ApiService) {

    suspend fun getAllAgents() : Flow<ApiResponse<List<AgentsItemResponse>>> {
        return flow {
            try {
                val response = apiService.getArticle(isPlayableCharacter = true)
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
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