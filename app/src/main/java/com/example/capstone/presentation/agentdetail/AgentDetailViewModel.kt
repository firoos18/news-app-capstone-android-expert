package com.example.capstone.presentation.agentdetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.core.domain.usecases.AgentUseCase
import com.example.capstone.core.utils.Constants
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class AgentDetailViewModel(
    private val agentUseCase: AgentUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = mutableStateOf(AgentDetailState())
    val state : State<AgentDetailState> get() = _state

    init {
        savedStateHandle.get<String>(Constants.AGENT_UUID)?.let { uuid ->
            getAgentDetail(uuid)
            Log.d("UUID", uuid)
        }
    }

    private fun getAgentDetail(uuid : String) {
        agentUseCase.getAgentById(uuid).map { agent ->
            _state.value = AgentDetailState(agents = agent)
        }.launchIn(viewModelScope)
    }

    fun setFavoriteAgent(agents: Agents, newStatus : Boolean) {
        agentUseCase.setFavoriteAgent(agents, newStatus)
    }
}