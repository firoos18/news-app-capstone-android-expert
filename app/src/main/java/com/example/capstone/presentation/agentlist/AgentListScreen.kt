package com.example.capstone.presentation.agentlist


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentListScreen(
    agentsListViewModel: AgentsListViewModel = koinViewModel(),
    navController: NavController
) {
    val state = agentsListViewModel.state.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.agents) { agent ->
            Text(
                text = agent.role
            )
            Divider()
        }
    }
}