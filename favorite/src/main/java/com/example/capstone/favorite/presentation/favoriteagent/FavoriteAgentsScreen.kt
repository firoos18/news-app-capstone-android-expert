package com.example.capstone.favorite.presentation.favoriteagent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.capstone.favorite.presentation.favoriteagent.components.FavoriteAgentsCard
import com.example.capstone.favorite.presentation.favoriteagent.di.favoriteModelModule
import com.example.capstone.presentation.Screen
import com.example.capstone.presentation.ui.theme.valorant
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.loadKoinModules

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteAgentsScreen(
    viewModel: FavoriteAgentViewModel = koinViewModel(),
    navController: NavController
) {
    val state = viewModel.state

    Scaffold(
        modifier = Modifier
            .padding(horizontal = 24.dp),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Favorite Agents",
                        fontFamily = valorant,
                        fontSize = 28.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(items = state.value.agents) { agents ->
                FavoriteAgentsCard(agents = agents, onItemClicked = {
                    navController.navigate(
                        Screen.AgentDetailScreen.route + "/${agents.uuid}"
                    )
                })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}