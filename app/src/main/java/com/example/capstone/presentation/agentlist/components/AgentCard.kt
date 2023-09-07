package com.example.capstone.presentation.agentlist.components

import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.presentation.Screen
import com.example.capstone.presentation.ui.theme.valorant
import java.util.Locale

@Composable
fun AgentCard(
    modifier : Modifier = Modifier,
    agents: Agents,
    onItemClick : (Agents) -> Unit,
) {
   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .padding(bottom = 36.dp, top = 24.dp)
   ) {
       Box{
           Column(
               verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
                   .align(Alignment.TopCenter),
           ) {
               Text(
                   text = agents.displayName.uppercase(),
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Bold,
                   fontFamily = valorant
               )
               Spacer(modifier = Modifier.height(4.dp))
               AsyncImage(
                   modifier = Modifier.size(24.dp),
                   model = agents.roleDisplayIcon,
                   contentDescription = "AgentRoleDisplayIcon"
               )
           }
           AsyncImage(
               modifier = Modifier
                   .width(630.dp)
                   .height(572.dp)
                   .align(Alignment.Center),
               model = agents.background,
               contentDescription = "AgentBackground"
           )
           AsyncImage(
               modifier = Modifier
                   .fillMaxHeight(),
               contentDescription = "AgentFullPortrait",
               model = agents.fullPortrait,
           )
           Spacer(modifier = Modifier.height(36.dp))
           Column(
               verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
                   .fillMaxSize()
                   .align(Alignment.BottomCenter),
           ) {
               Spacer(modifier = Modifier.height(8.dp))
               IconButton(
                   modifier = Modifier
                       .border(width = 1.dp, color = Color.Transparent, shape = CircleShape),
                   onClick = {
                       onItemClick(agents)
                   },
                   ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "AgentDetail",
                        modifier = Modifier
                            .size(36.dp)
                    )
               }
           }
        }
   }
}