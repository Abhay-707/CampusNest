package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: LogInViewModel = hiltViewModel()) {

    val signedIn by viewModel.SignedIn

    LaunchedEffect(key1 = !signedIn) {
        if (!signedIn) {
            navController.navigate("login_screen") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }

    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    val view = LocalView.current
    val density = LocalDensity.current.density
    systemUiController.setSystemBarsColor(
        color = Color.White, // Light theme color
        darkIcons = true
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(0.2f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 2.dp)
                    .background(color = Color.White)
                    .height(100.dp)
                    .weight(0.67f)
                    .clickable {
                        if (viewModel.Finding.value == false) {
                            viewModel.Finding.value = true
                        }
                        else viewModel.Finding.value = true
                    },
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.Finding.value) {
                        olive
                    } else {
                        yellow
                    }
                )

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "FIND",
                        fontFamily = Britannic,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        color = if (viewModel.Finding.value) {
                            yellow
                        } else {
                            olive
                        }
                    )

                }
            }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
                    .height(100.dp)
                    .background(color = Color.White)
                    .weight(0.33f)
                    .clickable {
                        if (viewModel.Finding.value) {
                            viewModel.Finding.value = false
                        }
                        else viewModel.Finding.value = false
                    },
                colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.Finding.value) {
                        yellow
                    } else {
                        olive
                    }
                )

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "U",
                        fontFamily = Britannic,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        color = if (viewModel.Finding.value) {
                            olive
                        } else {
                            yellow
                        }
                    )

                }

            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.1f)
        ) {
            if (viewModel.Finding.value) {
                FindApartment(navController , viewModel = viewModel)
            } else {
                Profile(navController ,viewModel)
            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
}


