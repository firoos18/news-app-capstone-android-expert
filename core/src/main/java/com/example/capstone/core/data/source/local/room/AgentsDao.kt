package com.example.capstone.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.capstone.core.data.source.local.entity.AgentsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentsDao {
    @Query("SELECT * FROM agent")
    fun getAllArticle() : Flow<List<AgentsEntity>>

    @Query("SELECT * FROM agent WHERE isFavorite = 1")
    fun getFavoriteArticle() : Flow<List<AgentsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article : List<AgentsEntity>)

    @Update
    fun updateFavoriteArticle(article : AgentsEntity)

    @Query("SELECT * FROM agent WHERE uuid = :uuid")
    fun getAgentById(uuid : String) : Flow<AgentsEntity>
}