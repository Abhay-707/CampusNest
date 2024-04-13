package com.innovateyou.pbl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.innovateyou.pbl.ui.theme.AddRoom
import com.innovateyou.pbl.ui.theme.HomeScreen
import com.innovateyou.pbl.ui.theme.LogInViewModel
import com.innovateyou.pbl.ui.theme.LoginScreen
import com.innovateyou.pbl.ui.theme.MainViewModel
import com.innovateyou.pbl.ui.theme.PBLTheme
import com.innovateyou.pbl.ui.theme.RoomDetailsScreen
import com.innovateyou.pbl.ui.theme.SignupScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PBLTheme {
                PBLTheme(darkTheme = false) {
                    SetBarColor(color = Color.White)
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ) {
                        val navController = rememberNavController()
                        val Lvm = hiltViewModel<LogInViewModel>()
                        NavHost(navController = navController, startDestination = "login_screen") {
                            composable("login_screen"){
                                LoginScreen(navController = navController ,viewModel = Lvm)
                            }
                            composable("signup_screen"){
                                SignupScreen(navController = navController, viewModel = Lvm)
                            }
                            composable("home_screen") {
                                HomeScreen(navController = navController , viewModel = Lvm)
                            }
                            composable("owner_screen"){
                                AddRoom(navController = navController, viewModel = Lvm)
                            }

                            composable(
                                "room_details_screen/{ImageResource}/{RoomName}/{Rating}/{Address}/{OwnerName}/{Price}/{Beds}/{Electricity}",
                                arguments = listOf(
                                    navArgument("ImageResource") {
                                        type = NavType.StringType
                                    },
                                    navArgument("RoomName") {
                                        type = NavType.StringType
                                    },
                                    navArgument("Rating") {
                                        type = NavType.StringType
                                    },
                                    navArgument("Address") {
                                        type = NavType.StringType
                                    },
                                    navArgument("OwnerName") {
                                        type = NavType.StringType
                                    },
                                    navArgument("Price") {
                                        type = NavType.StringType
                                    },
                                    navArgument("Beds") {
                                        type = NavType.IntType
                                    },
                                    navArgument("Electricity") {
                                        type = NavType.StringType
                                    }

                                )
                            ) { navBackStackEntry ->
                                RoomDetailsScreen(
                                    navController = navController,
                                    navBackStackEntry = navBackStackEntry
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color){
    val systemUicontroller = rememberSystemUiController()
    SideEffect {
        systemUicontroller.setSystemBarsColor(
            color = color
        )
    }
}

