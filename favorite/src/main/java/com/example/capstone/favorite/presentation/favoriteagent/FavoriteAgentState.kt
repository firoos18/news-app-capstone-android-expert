package com.example.capstone.favorite.presentation.favoriteagent

import com.example.capstone.core.domain.models.Agents

data class FavoriteAgentState(
    val isLoading : Boolean = false,
    var agents : List<Agents> = emptyList(),
    val error : String = ""
)
