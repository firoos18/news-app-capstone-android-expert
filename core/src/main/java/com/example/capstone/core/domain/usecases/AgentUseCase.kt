package com.example.capstone.core.domain.usecases

import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.models.Agents
import kotlinx.coroutines.flow.Flow

interface AgentUseCase {
    fun getAllAgents() : Flow<Resource<List<Agents>>>
    fun getFavoriteAgents() : Flow<List<Agents>>
    fun setFavoriteAgent(agent: Agents, state : Boolean)
    fun getAgentById(uuid : String) : Flow<Agents>
}