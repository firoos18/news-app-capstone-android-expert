package com.example.capstone.presentation.agentdetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capstone.presentation.agentdetail.components.AbilityCard
import com.example.capstone.presentation.ui.theme.valorant
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentDetailScreen(
    viewModel: AgentDetailViewModel = koinViewModel(),
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()
    var statusFavorite = state.agents?.isFavorite

    Scaffold(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 8.dp),
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color(0xffFFFBF5),
                onClick = {
                    statusFavorite = !statusFavorite!!
                    viewModel.setFavoriteAgent(state.agents!!, statusFavorite!!)
                }
            ) {
                if (statusFavorite == true) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "FavoriteAgent",
                        tint = Color(0xffFD4556)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "FavoriteAgent",
                        tint = Color(0xffFD4556)
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xffFFFBF5))
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            AsyncImage(
                model = state.agents?.background,
                contentDescription = "AgentBackground",
                colorFilter = ColorFilter.tint(Color(0x10FD4556)),
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(630.dp)
                    .height(572.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
                    .verticalScroll(scrollState)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(125.dp)
                            .clip(shape = RoundedCornerShape(7.dp))
                            .background(Color(0xffBD3944))
                    ) {
                        AsyncImage(
                            model = state.agents?.displayIcon,
                            contentDescription = "AgentDisplayIcon",
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = state.agents?.displayName.toString().uppercase(),
                            fontSize = 42.sp,
                            fontFamily = valorant
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = state.agents?.roleDisplayIcon,
                                contentDescription = "RoleDisplayIcon",
                                colorFilter = ColorFilter.tint(Color(0xffFD4556)),
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = state.agents?.roleDisplayName.toString().uppercase()
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = state.agents?.description.toString(),
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = "ABILITIES",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(16.dp))
                AbilityCard(abilityName = state.agents?.ability1Name.toString(), abilityDescription = state.agents?.ability1Description.toString(), abilityIcon = state.agents?.ability1DisplayIcon.toString())
                Spacer(modifier = Modifier.height(8.dp))
                AbilityCard(abilityName = state.agents?.ability2Name.toString(), abilityDescription = state.agents?.ability2Description.toString(), abilityIcon = state.agents?.ability2DisplayIcon.toString())
                Spacer(modifier = Modifier.height(8.dp))
                AbilityCard(abilityName = state.agents?.ability3Name.toString(), abilityDescription = state.agents?.ability3Description.toString(), abilityIcon = state.agents?.ability3DisplayIcon.toString())
                Spacer(modifier = Modifier.height(8.dp))
                AbilityCard(abilityName = state.agents?.ability4Name.toString(), abilityDescription = state.agents?.ability4Description.toString(), abilityIcon = state.agents?.ability4DisplayIcon.toString())
            }
        }
    }
}