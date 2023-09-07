package com.example.capstone.favorite.presentation.favoriteagent.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capstone.core.domain.models.Agents
import com.example.capstone.presentation.ui.theme.valorant

@Composable
fun FavoriteAgentsCard(
    agents: Agents,
    onItemClicked : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xff323030))
            .padding(8.dp)
            .clickable { onItemClicked() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = RoundedCornerShape(7.dp))
                    .background(Color(0xffBD3944))
            ) {
                AsyncImage(
                    model = agents.displayIcon,
                    contentDescription = "AgentDisplayIcon",
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = agents.displayName.uppercase(),
                    color = Color(0xffFFFBF5),
                    fontSize = 16.sp,
                    fontFamily = valorant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = agents.roleDisplayIcon,
                        contentDescription = "RoleDisplayIcon",
                        modifier = Modifier.size(16.dp),
                        colorFilter = ColorFilter.tint(Color(0xffFD4556))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = agents.roleDisplayName,
                        color = Color(0xffFFFBF5),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}