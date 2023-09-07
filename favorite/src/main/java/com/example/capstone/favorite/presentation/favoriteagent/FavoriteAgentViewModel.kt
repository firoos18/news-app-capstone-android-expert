package com.example.capstone.favorite.presentation.favoriteagent

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.core.domain.usecases.AgentUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FavoriteAgentViewModel(
    private val agentUseCase : AgentUseCase
) : ViewModel() {
    private val _state = mutableStateOf(FavoriteAgentState())
    val state : State<FavoriteAgentState> get() = _state

    init {
        getFavoriteAgents()
        Log.d("FavoriteAgents", state.value.agents.toString())
    }

    private fun getFavoriteAgents() {
        agentUseCase.getFavoriteAgents().onEach {  agents ->
            _state.value = FavoriteAgentState(agents = agents)
        }.launchIn(viewModelScope)
    }
}