package com.example.capstone

import android.app.Application
import com.example.capstone.core.di.databaseModule
import com.example.capstone.core.di.networkModule
import com.example.capstone.core.di.repositoryModule
import com.example.capstone.di.useCaseModule
import com.example.capstone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ValorantAgentsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ValorantAgentsApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}