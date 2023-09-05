package com.example.capstone.core.domain.models


data class FavoriteAgents(
    var uuid: String,
    var role: String,
    var displayName: String,
    var description: String,
    var isFavorite : Boolean
)