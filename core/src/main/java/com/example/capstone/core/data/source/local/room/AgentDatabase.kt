package com.example.capstone.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.capstone.core.data.source.local.entity.AgentsEntity

@Database(entities = [AgentsEntity::class], version = 1, exportSchema = false)
abstract class AgentDatabase : RoomDatabase() {

    abstract fun agentDao() : AgentsDao

}