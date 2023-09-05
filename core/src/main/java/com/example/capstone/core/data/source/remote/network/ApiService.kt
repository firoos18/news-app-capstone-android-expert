package com.example.capstone.core.data.source.remote.network

import com.example.capstone.core.data.source.remote.response.ListAgentsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v1/agents/")
    suspend fun getArticle(
    ) : ListAgentsResponse
}