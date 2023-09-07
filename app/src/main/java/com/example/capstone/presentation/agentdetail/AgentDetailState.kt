package com.example.capstone.presentation.agentdetail

import com.example.capstone.core.domain.models.Agents

data class AgentDetailState(
    val isLoading : Boolean = false,
    var agents : Agents? = null,
    val error : String = ""
)
