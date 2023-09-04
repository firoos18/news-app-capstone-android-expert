package com.example.capstone.core.data.source.remote.network

import com.example.capstone.core.data.source.remote.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getArticle(
        @Query("apiKey") apiKey : String,
        @Query("country") country : String,
    ) : ListNewsResponse
}