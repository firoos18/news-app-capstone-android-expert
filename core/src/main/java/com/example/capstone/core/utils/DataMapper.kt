package com.example.capstone.core.utils

import com.example.capstone.core.data.source.local.entity.AgentsEntity
import com.example.capstone.core.data.source.remote.response.AgentsItemResponse
import com.example.capstone.core.data.source.remote.response.Role
import com.example.capstone.core.data.source.remote.response.VoiceLine
import com.example.capstone.core.domain.models.Agents

object DataMapper {
    fun mapResponsesToEntities(input: List<AgentsItemResponse>): List<AgentsEntity> {
        val agentList = ArrayList<AgentsEntity>()
        input.map {
            val agent = AgentsEntity(
                uuid = it.uuid,
                displayName = it.displayName,
                isFavorite = false,
                description = it.description,
                role = it.role.displayName,
            )
            agentList.add(agent)
        }
        return agentList
    }

    fun mapEntitiesToDomain(input: List<AgentsEntity>): List<Agents> =
        input.map {
            Agents(
                uuid = it.uuid,
                description = it.description,
                role = Role(displayIcon = "", displayName = it.role, assetPath = "", uuid = "", description = ""),
                displayName = it.displayName,
                abilities = emptyList(),
                voiceLine = VoiceLine(minDuration = 0f, maxDuration = 0f, mediaList = emptyList()),
                background = "",
                developerName = "",
                displayIconSmall = "",
                fullPortrait = ""
            )
        }

    fun mapDomainToEntity(input: Agents) = AgentsEntity(
        uuid = input.uuid,
        description = input.description,
        displayName = input.displayName,
        role = input.role.displayName,
        isFavorite = false,
    )
}