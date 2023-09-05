package com.example.capstone.core.data.source.remote.response

import com.example.capstone.core.data.source.local.entity.AgentsEntity
import com.example.capstone.core.domain.models.Agents
import com.google.gson.annotations.SerializedName

data class AgentsItemResponse(

	@field:SerializedName("killfeedPortrait")
	val killfeedPortrait: String,

	@field:SerializedName("role")
	val role: Role,

	@field:SerializedName("isFullPortraitRightFacing")
	val isFullPortraitRightFacing: Boolean,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("isBaseContent")
	val isBaseContent: Boolean,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("backgroundGradientColors")
	val backgroundGradientColors: List<String>,

	@field:SerializedName("isAvailableForTest")
	val isAvailableForTest: Boolean,

	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("characterTags")
	val characterTags: Any,

	@field:SerializedName("displayIconSmall")
	val displayIconSmall: String,

	@field:SerializedName("fullPortrait")
	val fullPortrait: String,

	@field:SerializedName("fullPortraitV2")
	val fullPortraitV2: String,

	@field:SerializedName("abilities")
	val abilities: List<AbilitiesItem>,

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("recruitmentData")
	val recruitmentData: Any,

	@field:SerializedName("bustPortrait")
	val bustPortrait: String,

	@field:SerializedName("background")
	val background: String,

	@field:SerializedName("assetPath")
	val assetPath: String,

	@field:SerializedName("voiceLine")
	val voiceLine: VoiceLine,

	@field:SerializedName("isPlayableCharacter")
	val isPlayableCharacter: Boolean,

	@field:SerializedName("developerName")
	val developerName: String
)

fun AgentsItemResponse.toAgentEntity() : AgentsEntity =
	AgentsEntity(
		uuid = uuid,
		role = role.displayName,
		displayName = displayName,
		description = description,
		isFavorite = false,
	)

fun AgentsItemResponse.toAgents() : Agents =
	Agents(
		uuid,
		role,
		displayName,
		description,
		fullPortrait,
		displayIconSmall,
		abilities,
		background,
		voiceLine,
		developerName,
	)