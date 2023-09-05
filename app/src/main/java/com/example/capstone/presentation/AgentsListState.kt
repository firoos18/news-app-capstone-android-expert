package com.example.capstone.presentation

import com.example.capstone.core.domain.models.Agents

data class AgentsListState(
    val isLoading : Boolean = false,
    val news : List<Agents> = emptyList(),
    val error : String = ""
)
