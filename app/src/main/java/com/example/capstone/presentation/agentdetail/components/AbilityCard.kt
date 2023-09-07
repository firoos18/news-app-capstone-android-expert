package com.example.capstone.presentation.agentdetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun AbilityCard(
    abilityName : String,
    abilityDescription : String,
    abilityIcon : String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(7.dp))
                .background(Color(0xffBD3944))
        ) {
            AsyncImage(
                model = abilityIcon,
                contentDescription = "AbilityIcon",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = abilityName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = abilityDescription,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Justify,
                lineHeight = 16.sp
            )
        }
    }
}