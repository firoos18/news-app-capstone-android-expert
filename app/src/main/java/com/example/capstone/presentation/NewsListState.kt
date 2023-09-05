package com.example.capstone.presentation

import com.example.capstone.core.domain.models.ArticlesItem

data class NewsListState(
    val isLoading : Boolean = false,
    val news : List<ArticlesItem> = emptyList(),
    val error : String = ""
)
