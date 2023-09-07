package com.example.capstone.presentation.agentlist


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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.size.Size
import com.example.capstone.presentation.Screen
import com.example.capstone.presentation.agentlist.components.AgentCard
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentListScreen(
    agentsListViewModel: AgentsListViewModel = koinViewModel(),
    navController: NavController
) {
    val state = agentsListViewModel.state.value
    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffFD4556))
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