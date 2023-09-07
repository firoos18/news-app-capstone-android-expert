package com.example.capstone.core.domain.models

import com.example.capstone.core.data.source.remote.response.AbilitiesItem
import com.example.capstone.core.data.source.remote.response.Role
import com.example.capstone.core.data.source.remote.response.VoiceLine
data class Agents(

    val uuid: String,
    val displayName: String,
    val fullPortrait: String,
    val description : String,
    val background: String,
    val roleDisplayIcon: String,
    val roleDisplayName : String,
    val displayIcon : String,
    val isFavorite : Boolean,
    val ability1Name : String,
    val ability1DisplayIcon : String,
    val ability1Description : String,
    val ability2Name : String,
    val ability2DisplayIcon : String,
    val ability2Description : String,
    val ability3Name : String,
    val ability3DisplayIcon : String,
    val ability3Description : String,
    val ability4Name : String,
    val ability4DisplayIcon : String,
    val ability4Description : String,

)
