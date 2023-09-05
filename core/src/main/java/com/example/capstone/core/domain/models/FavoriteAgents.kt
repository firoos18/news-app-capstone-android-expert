package com.example.capstone.core.domain.models

import com.example.capstone.core.data.source.remote.response.AbilitiesItem
import com.example.capstone.core.data.source.remote.response.Role


data class FavoriteAgents(
    var uuid: String,
    var role: Role,
    var displayName: String,
    var abilities: List<AbilitiesItem>,
    var description: String,
    var isFavorite : Boolean,
    val background : String,
    val fullPortrait : String,
)