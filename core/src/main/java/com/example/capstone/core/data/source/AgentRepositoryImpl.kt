package com.example.capstone.core.data.source

import com.example.capstone.core.data.source.local.LocalDataSource
import com.example.capstone.core.data.source.remote.RemoteDataSource
import com.example.capstone.core.data.source.remote.network.ApiResponse
import com.example.capstone.core.data.source.remote.response.AgentsItemResponse
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.core.domain.models.FavoriteAgents
import com.example.capstone.core.domain.repository.AgentRepository
import com.example.capstone.core.utils.AppExecutors
import com.example.capstone.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AgentRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : AgentRepository {
    override fun getAllAgents(): Flow<Resource<List<Agents>>> {
        return object : NetworkBoundResource<List<Agents>, List<AgentsItemResponse>>() {
            override fun loadFromDB(): Flow<List<Agents>> {
                return localDataSource.getAllAgents().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Agents>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<AgentsItemResponse>>> =
                remoteDataSource.getAllAgents()

            override suspend fun saveCallResult(data: List<AgentsItemResponse>) {
                val agentList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAgents(agentList)
            }

        }.asFlow()
    }

    override fun getFavoriteAgents(): Flow<List<Agents>> {
        return localDataSource.getFavoriteAgents().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAgent(agents: Agents, state: Boolean) {
        val agentsEntity = DataMapper.mapDomainToEntity(agents)
        appExecutors.diskIO().execute{ localDataSource.setFavoriteAgent(agentsEntity, state) }
    }
}