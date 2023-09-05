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
                role = it.role.uuid,
                fullPortrait = it.fullPortrait,
                background = it.background,
            )
            agentList.add(agent)
        }
        return agentList
    }

    fun mapEntitiesToDomain(input: List<AgentsEntity>): List<Agents> =
        input.map {
            Agents(
                uuid = it.uuid,
                role = it.role,
                displayName = it.displayName,
                background = it.background,
                fullPortrait = it.fullPortrait
            )
        }

    fun mapDomainToEntity(input: Agents) = AgentsEntity(
        uuid = input.uuid,
        displayName = input.displayName,
        role = input.role,
        background = input.background,
        fullPortrait = input.fullPortrait,
        isFavorite = false,
    )
}