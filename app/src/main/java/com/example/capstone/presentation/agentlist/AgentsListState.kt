package com.example.capstone.presentation.agentlist

import com.example.capstone.core.domain.models.Agents

data class AgentsListState(
    val isLoading : Boolean = false,
    val agents : List<Agents> = emptyList(),
    val error : String = ""
)
