package com.example.capstone.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.core.domain.models.FavoriteAgents

@Entity(tableName = "agent")
data class AgentsEntity(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    var uuid: String,

    @ColumnInfo(name = "role")
    var role: String,

    @ColumnInfo(name = "displayName")
    var displayName: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false
)

fun AgentsEntity.toFavoriteAgent() : FavoriteAgents =
    FavoriteAgents(
        uuid = uuid,
        displayName = displayName,
        role = role,
        description = description,
        isFavorite = isFavorite,
    )