package com.example.capstone.core.data.source.local

import com.example.capstone.core.data.source.local.entity.AgentsEntity
import com.example.capstone.core.data.source.local.room.AgentsDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val agentsDao: AgentsDao) {

    fun getAllAgents() : Flow<List<AgentsEntity>> = agentsDao.getAllArticle()

    fun getFavoriteAgents() : Flow<List<AgentsEntity>> = agentsDao.getFavoriteArticle()

    suspend fun insertAgents(agentList : List<AgentsEntity>) = agentsDao.insertArticle(agentList)

    fun setFavoriteAgent(agents : AgentsEntity, newState : Boolean) {
        agents.isFavorite = newState
        agentsDao.updateFavoriteArticle(agents)
    }
}