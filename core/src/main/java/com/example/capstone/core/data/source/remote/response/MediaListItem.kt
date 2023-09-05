package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MediaListItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("wave")
	val wave: String,

	@field:SerializedName("wwise")
	val wwise: String
)