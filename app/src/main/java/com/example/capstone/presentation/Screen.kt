package com.example.capstone.presentation

sealed class Screen(val route : String) {
    object AgentListScreen : Screen("agent_list_screen")
    object AgentDetailScreen : Screen("agent_detail_screen")
}