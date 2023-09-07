package com.example.capstone.presentation.agentlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.usecases.AgentUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AgentsListViewModel (
    private val agentUseCase: AgentUseCase
) : ViewModel() {
    private val _state = mutableStateOf(AgentsListState())
    val state : State<AgentsListState> get() = _state

    init {
        getAllArticles()
    }

    private fun getAllArticles() {
        val article = agentUseCase.getAllAgents()
        article.onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = AgentsListState(agents = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AgentsListState(error = result.message ?:
                    "An Unexpected Error Occurred!")
                }
                is Resource.Loading -> {
                    _state.value = AgentsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}