package com.example.capstone.core.data.source.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.capstone.core.domain.models.ArticlesItem
import com.google.gson.annotations.SerializedName

data class ListNewsResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItemResponse>,

	@field:SerializedName("status")
	val status: String? = null
)
