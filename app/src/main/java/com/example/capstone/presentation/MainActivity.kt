package com.example.capstone.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstone.presentation.agentlist.AgentListScreen
import com.example.capstone.presentation.agentdetail.AgentDetailScreen
import com.example.capstone.presentation.ui.theme.CapstoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AgentListScreen.route
                    ) {
                        composable(
                            route = Screen.AgentListScreen.route
                        ) {
                            AgentListScreen(navController = navController)
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