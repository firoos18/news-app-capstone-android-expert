package com.example.capstone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RecruitmentData(

	@field:SerializedName("levelVpCostOverride")
	val levelVpCostOverride: Int,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("milestoneThreshold")
	val milestoneThreshold: Int,

	@field:SerializedName("milestoneId")
	val milestoneId: String,

	@field:SerializedName("useLevelVpCostOverride")
	val useLevelVpCostOverride: Boolean,

	@field:SerializedName("counterId")
	val counterId: String,

	@field:SerializedName("startDate")
	val startDate: String
)