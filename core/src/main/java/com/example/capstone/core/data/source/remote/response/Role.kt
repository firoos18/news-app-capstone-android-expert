package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Role(

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("assetPath")
	val assetPath: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("uuid")
	val uuid: String
)