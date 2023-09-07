package com.example.capstone.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agent")
data class AgentsEntity(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    val uuid: String,

    @ColumnInfo(name = "displayName")
    val displayName: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "fullPortrait")
    val fullPortrait: String,

    @ColumnInfo(name = "background")
    val background: String,

    @ColumnInfo(name = "roleDisplayIcon")
    val roleDisplayIcon: String,

    @ColumnInfo(name = "roleDisplayName")
    val roleDisplayName : String,

    @ColumnInfo(name = "displayIcon")
    val displayIcon : String,

    @ColumnInfo(name = "ability1Name")
    val ability1Name : String,

    @ColumnInfo(name = "ability1DisplayIcon")
    val ability1DisplayIcon : String,

    @ColumnInfo(name = "ability1Description")
    val ability1Description : String,

    @ColumnInfo(name = "ability2Name")
    val ability2Name : String,

    @ColumnInfo(name = "ability2DisplayIcon")
    val ability2DisplayIcon : String,

    @ColumnInfo(name = "ability2Description")
    val ability2Description : String,

    @ColumnInfo(name = "ability3Name")
    val ability3Name : String,

    @ColumnInfo(name = "ability3DisplayIcon")
    val ability3DisplayIcon : String,

    @ColumnInfo(name = "ability3Description")
    val ability3Description : String,

    @ColumnInfo(name = "ability4Name")
    val ability4Name : String,

    @ColumnInfo(name = "ability4DisplayIcon")
    val ability4DisplayIcon : String,

    @ColumnInfo(name = "ability4Description")
    val ability4Description : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false,
)