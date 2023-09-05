package com.example.capstone.presentation.newslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.usecases.AgentUseCase
import com.example.capstone.presentation.NewsListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewsListViewModel (
    private val agentUseCase: AgentUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NewsListState())
    val state : State<NewsListState> get() = _state

    init {
        getAllArticles()
    }

    private fun getAllArticles() {
        val article = agentUseCase.getAllAgents()
        article.onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = NewsListState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NewsListState(error = result.message ?:
                    "An Unexpected Error Occurred!")
                }
                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}