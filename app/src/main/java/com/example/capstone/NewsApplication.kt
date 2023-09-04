package com.example.capstone

import android.app.Application
import com.example.capstone.core.di.databaseModule
import com.example.capstone.core.di.networkModule
import com.example.capstone.core.di.repositoryModule
import org.koin.core.context.startKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                )
            )
        }
    }
}