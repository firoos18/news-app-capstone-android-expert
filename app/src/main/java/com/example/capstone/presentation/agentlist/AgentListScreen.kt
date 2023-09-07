package com.example.capstone.presentation.agentlist


import android.content.Intent
import android.net.Uri
import android.widget.StackView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.size.Size
import com.example.capstone.presentation.Screen
import com.example.capstone.presentation.agentlist.components.AgentCard
import com.example.capstone.presentation.ui.theme.valorant
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AgentListScreen(
    agentsListViewModel: AgentsListViewModel = koinViewModel(),
    navController: NavController
) {
    val state = agentsListViewModel.state.value
    val scrollState = rememberLazyListState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                     Text(
                         text = "VALORANT AGENTS",
                         fontFamily = valorant,
                         fontSize = 28.sp
                     )
                },
                actions = {
                    IconButton(onClick = {
                        val uri = Uri.parse("valorantagentsapp://favorite")
                        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "FavoriteAgents",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffFD4556))
                .padding(it)
        ) {
            LazyRow(
                modifier = Modifier
                    .background(Color(0xffFD4556))
                    .align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically,
                state = scrollState,
                flingBehavior = rememberSnapFlingBehavior(lazyListState = scrollState)
            ) {
                items(state.agents) { agent ->
                    AgentCard(
                        agents = agent,
                        onItemClick = {
                            navController.navigate(
                                Screen.AgentDetailScreen.route + "/${agent.uuid}"
                            )
                        }
                    )
                }
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}