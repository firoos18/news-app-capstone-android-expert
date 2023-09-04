package com.example.capstone.core.di

import androidx.room.Room
import com.example.capstone.core.data.source.ArticleRepositoryImpl
import com.example.capstone.core.data.source.local.LocalDataSource
import com.example.capstone.core.data.source.local.room.ArticleDatabase
import com.example.capstone.core.data.source.remote.RemoteDataSource
import com.example.capstone.core.data.source.remote.network.ApiService
import com.example.capstone.core.domain.repository.ArticleRepository
import com.example.capstone.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<ArticleDatabase>().articleDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ArticleDatabase::class.java,
            "Article.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ArticleRepository> {
        ArticleRepositoryImpl(get(), get(), get())
    }
}