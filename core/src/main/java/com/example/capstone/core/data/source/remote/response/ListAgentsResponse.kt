package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListAgentsResponse(

	@field:SerializedName("data")
	val data: List<AgentsItemResponse>,

	@field:SerializedName("status")
	val status: Int
)