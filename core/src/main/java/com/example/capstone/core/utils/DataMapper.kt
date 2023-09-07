package com.example.capstone.core.utils

import com.example.capstone.core.data.source.local.entity.AgentsEntity
import com.example.capstone.core.data.source.remote.response.AgentsItemResponse
import com.example.capstone.core.domain.models.Agents

object DataMapper {
    fun mapResponsesToEntities(input: List<AgentsItemResponse>): List<AgentsEntity> {
        val agentList = ArrayList<AgentsEntity>()
        input.map {
            val agent = AgentsEntity(
                uuid = it.uuid,
                displayName = it.displayName,
                isFavorite = false,
                roleDisplayName = it.role.displayName,
                roleDisplayIcon = it.role.displayIcon,
                fullPortrait = it.fullPortrait,
                background = it.background,
                description = it.description,
                displayIcon = it.displayIcon,
                ability1Description = it.abilities[0].description,
                ability1Name = it.abilities[0].displayName,
                ability1DisplayIcon = it.abilities[0].displayIcon,
                ability2Description = it.abilities[1].description,
                ability2Name = it.abilities[1].displayName,
                ability2DisplayIcon = it.abilities[1].displayIcon,
                ability3Description = it.abilities[2].description,
                ability3Name = it.abilities[2].displayName,
                ability3DisplayIcon = it.abilities[2].displayIcon,
                ability4Description = it.abilities[3].description,
                ability4Name = it.abilities[3].displayName,
                ability4DisplayIcon = it.abilities[3].displayIcon,
            )
            agentList.add(agent)
        }
        return agentList
    }

    fun mapEntitiesToDomain(input: List<AgentsEntity>): List<Agents> =
        input.map {
            Agents(
                uuid = it.uuid,
                roleDisplayIcon = it.roleDisplayIcon,
                roleDisplayName = it.roleDisplayName,
                displayName = it.displayName,
                background = it.background,
                description = it.description,
                fullPortrait = it.fullPortrait,
                displayIcon = it.displayIcon,
                isFavorite = it.isFavorite,
                ability1DisplayIcon = it.ability1DisplayIcon,
                ability1Name = it.ability1Name,
                ability1Description = it.ability1Description,
                ability2DisplayIcon = it.ability2DisplayIcon,
                ability2Name = it.ability2Name,
                ability2Description = it.ability2Description,
                ability3DisplayIcon = it.ability3DisplayIcon,
                ability3Name = it.ability3Name,
                ability3Description = it.ability3Description,
                ability4DisplayIcon = it.ability4DisplayIcon,
                ability4Name = it.ability4Name,
                ability4Description = it.ability4Description,
            )
        }

    fun mapDomainToEntity(input: Agents) = AgentsEntity(
        uuid = input.uuid,
        displayName = input.displayName,
        description = input.description,
        roleDisplayName = input.roleDisplayName,
        roleDisplayIcon = input.roleDisplayIcon,
        displayIcon = input.displayIcon,
        background = input.background,
        fullPortrait = input.fullPortrait,
        isFavorite = input.isFavorite,
        ability1DisplayIcon = input.ability1DisplayIcon,
        ability1Name = input.ability1Name,
        ability1Description = input.ability1Description,
        ability2DisplayIcon = input.ability2DisplayIcon,
        ability2Name = input.ability2Name,
        ability2Description = input.ability2Description,
        ability3DisplayIcon = input.ability3DisplayIcon,
        ability3Name = input.ability3Name,
        ability3Description = input.ability3Description,
        ability4DisplayIcon = input.ability4DisplayIcon,
        ability4Name = input.ability4Name,
        ability4Description = input.ability4Description,
    )

    fun mapEntityToDomain(input : AgentsEntity) : Agents =
        Agents(
            uuid = input.uuid,
            roleDisplayIcon = input.roleDisplayIcon,
            roleDisplayName = input.roleDisplayName,
            displayName = input.displayName,
            background = input.background,
            description = input.description,
            fullPortrait = input.fullPortrait,
            displayIcon = input.displayIcon,
            isFavorite = input.isFavorite,
            ability1DisplayIcon = input.ability1DisplayIcon,
            ability1Name = input.ability1Name,
            ability1Description = input.ability1Description,
            ability2DisplayIcon = input.ability2DisplayIcon,
            ability2Name = input.ability2Name,
            ability2Description = input.ability2Description,
            ability3DisplayIcon = input.ability3DisplayIcon,
            ability3Name = input.ability3Name,
            ability3Description = input.ability3Description,
            ability4DisplayIcon = input.ability4DisplayIcon,
            ability4Name = input.ability4Name,
            ability4Description = input.ability4Description,
        )
}