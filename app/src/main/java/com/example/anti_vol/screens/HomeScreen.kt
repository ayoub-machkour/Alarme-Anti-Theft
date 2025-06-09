package com.example.anti_vol.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anti_vol.R
import com.example.anti_vol.ui.theme.AppColors

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // LOGO
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Title (big text = 32sp)
            Text(
                text = "Alarm Anti theft",
                fontSize = 32.sp,
                color = AppColors.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Keep you phone safe from nosy people and thieves",
                fontSize = 13.sp,
                color = AppColors.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }

        // Auto-navigate to next screen after 2 seconds
        LaunchedEffect(Unit) {
            kotlinx.coroutines.delay(2000)
            navController.navigate("intro1")
        }
    }
}