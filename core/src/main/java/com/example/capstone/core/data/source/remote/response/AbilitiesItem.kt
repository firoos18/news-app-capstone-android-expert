package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AbilitiesItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("slot")
	val slot: String
)