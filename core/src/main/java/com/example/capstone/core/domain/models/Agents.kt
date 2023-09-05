package com.example.capstone.core.domain.models

import com.example.capstone.core.data.source.remote.response.AbilitiesItem
import com.example.capstone.core.data.source.remote.response.Role
import com.example.capstone.core.data.source.remote.response.VoiceLine
data class Agents(

    val uuid: String,
    val role: String,
    val displayName: String,
    val fullPortrait: String,
    val background: String,

)
