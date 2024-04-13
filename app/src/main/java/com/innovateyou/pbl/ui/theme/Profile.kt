package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun Profile(navController: NavController ,viewModel: LogInViewModel = hiltViewModel()){
    val signedIn by viewModel.SignedIn

    LaunchedEffect(key1 = !signedIn) {
        if (!signedIn) {
            viewModel.Finding.value = true
            navController.navigate("login_screen") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }



    Column(modifier = Modifier.fillMaxSize().background(yellow)){
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
            .clickable {
                viewModel.signOut()
            },
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = olive)){
            Text(
                text = "Sign Out",
                fontFamily = Britannic,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(16.dp)
            )
        }

    }
}