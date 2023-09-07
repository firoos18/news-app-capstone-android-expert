package com.example.capstone.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstone.favorite.R
import com.example.capstone.favorite.presentation.favoriteagent.FavoriteAgentsScreen
import com.example.capstone.favorite.presentation.favoriteagent.di.favoriteModelModule
import com.example.capstone.presentation.Screen
import com.example.capstone.presentation.agentdetail.AgentDetailScreen
import com.example.capstone.presentation.agentlist.AgentListScreen
import com.example.capstone.presentation.ui.theme.CapstoneTheme
import org.koin.core.context.loadKoinModules

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(favoriteModelModule)

        setContent {
            CapstoneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffFFFBF5)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "favorite_agent_screen"
                    ) {
                        composable(
                            route = Screen.AgentListScreen.route
                        ) {
                            AgentListScreen(navController = navController)
                        }
                        composable(
                            route = "favorite_agent_screen"
                        ) {
                            FavoriteAgentsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AgentDetailScreen.route + "/{agentUuid}"
                        ) {
                            AgentDetailScreen()
                        }
                    }
                }
            }
        }
    }
}