package com.example.capstone.core.domain.repository

import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.models.Agents
import kotlinx.coroutines.flow.Flow

interface AgentRepository {

    fun getAllAgents() : Flow<Resource<List<Agents>>>

    fun getFavoriteAgents() : Flow<List<Agents>>

    fun setFavoriteAgent(agents: Agents, state : Boolean)

    fun getAgentById(uuid : String) : Flow<Agents>

}