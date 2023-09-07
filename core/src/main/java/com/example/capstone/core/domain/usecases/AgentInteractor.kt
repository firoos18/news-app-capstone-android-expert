package com.example.capstone.core.domain.usecases

import com.example.capstone.core.data.source.Resource
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.core.domain.repository.AgentRepository
import kotlinx.coroutines.flow.Flow

class AgentInteractor(private val agentRepository: AgentRepository) : AgentUseCase {
    override fun getAllAgents(): Flow<Resource<List<Agents>>> = agentRepository.getAllAgents()

    override fun getFavoriteAgents(): Flow<List<Agents>>  = agentRepository.getFavoriteAgents()

    override fun setFavoriteAgent(agent: Agents, state: Boolean) = agentRepository.setFavoriteAgent(agent, state)

    override fun getAgentById(uuid: String): Flow<Agents> = agentRepository.getAgentById(uuid)
}