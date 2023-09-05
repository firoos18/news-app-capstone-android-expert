package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class VoiceLine(

	@field:SerializedName("minDuration")
	val minDuration: Float,

	@field:SerializedName("mediaList")
	val mediaList: List<MediaListItem>,

	@field:SerializedName("maxDuration")
	val maxDuration: Float
)