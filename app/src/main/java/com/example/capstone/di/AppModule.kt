package com.example.capstone.di

import com.example.capstone.core.domain.usecases.AgentInteractor
import com.example.capstone.core.domain.usecases.AgentUseCase
import com.example.capstone.presentation.agentdetail.AgentDetailViewModel
import com.example.capstone.presentation.agentlist.AgentsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AgentUseCase> { AgentInteractor(get()) }
}

val viewModelModule = module {
    viewModel { AgentsListViewModel(get()) }
    viewModel { AgentDetailViewModel(get(), get()) }
}