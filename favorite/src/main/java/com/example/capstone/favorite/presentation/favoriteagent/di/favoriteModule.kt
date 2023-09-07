package com.example.capstone.favorite.presentation.favoriteagent.di

import com.example.capstone.favorite.presentation.favoriteagent.FavoriteAgentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModelModule = module {
    viewModel { FavoriteAgentViewModel(get()) }
}