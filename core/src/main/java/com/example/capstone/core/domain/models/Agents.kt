package com.example.capstone.core.domain.models

import com.example.capstone.core.data.source.remote.response.AbilitiesItem
import com.example.capstone.core.data.source.remote.response.Role
import com.example.capstone.core.data.source.remote.response.VoiceLine
import com.google.gson.annotations.SerializedName

data class Agents(

    val uuid: String,
    val role: Role,
    val displayName: String,
    val description: String,
    val fullPortrait: String,
    val displayIconSmall: String,
    val abilities: List<AbilitiesItem>,
    val background: String,
    val voiceLine: VoiceLine,
    val developerName: String

)
