package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.innovateyou.pbl.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController , viewModel: LogInViewModel) {
    val systemUiController = rememberSystemUiController()
    val empty by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false) }
    var errorinE by remember{ mutableStateOf(false) }
    var errorinP by remember{ mutableStateOf(false) }
    var selectedMode by viewModel.selectedMode
    systemUiController.setSystemBarsColor(
        color = olive,
        darkIcons = false
    )
    val signedIn by viewModel.SignedIn
    val inProgress by viewModel.InProgress
    LaunchedEffect(signedIn) {
        if (signedIn && selectedMode =="student") {
            navController.navigate("home_screen")
        }
        else if (signedIn && selectedMode == "owner"){
            navController.navigate("owner_screen")
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.r4), contentDescription = "", contentScale = ContentScale.Crop)

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            olive,
                            olive1,
                            transperant,
                            transperant
                        )
                    )
                )

        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            shadowElevation = 50.dp,
            shape = ShapeDefaults.Medium,
            color = Color.White
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth().weight(0.2f)){
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(16.dp)
                            .clickable { selectedMode = "student" },
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        colors =
                        CardDefaults.cardColors(containerColor = if(selectedMode == "student"){ olive}else{ yellow})
                    ){Text(
                        text = "Student",
                        fontFamily = Britannic,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = if(selectedMode == "student"){ yellow}else{ olive},
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f)
                            .padding(16.dp)
                    )}
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(16.dp)
                            .clickable { selectedMode = "owner" },
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = if(selectedMode == "owner"){ olive}else{ yellow})
                    ){Text(
                        text = "Owner",
                        fontFamily = Britannic,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = if(selectedMode == "owner"){ yellow}else{ olive},
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f)
                            .padding(16.dp)
                    )}
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    TextField(value = email , onValueChange = {email = it },
                        maxLines = 1, label = { Text(text = "Email")},
                        colors = TextFieldDefaults
                            .textFieldColors(
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                focusedLabelColor = olive,
                                unfocusedLabelColor = olive),
                        modifier = Modifier.fillMaxSize(),
                        trailingIcon = {
                            if(password.isNotEmpty()){
                                Icon(imageVector = Icons.Default.Close, contentDescription = "" , modifier = Modifier.clickable { email = "" })
                            }
                        } ,
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")}
                    )

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    TextField(value = password , onValueChange ={password = it },
                        maxLines = 1, label = { Text(text = "Password")},
                        visualTransformation = VisualTransformation.None,
                        colors = TextFieldDefaults
                            .textFieldColors(
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                focusedLabelColor = olive,
                                unfocusedLabelColor = olive),
                        modifier = Modifier.fillMaxSize(),
                        trailingIcon = {
                            if(password.isNotEmpty()){
                                Icon(imageVector = Icons.Default.Close, contentDescription = "" , modifier = Modifier.clickable { password = "" })
                            }
                        } ,
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")}


                    )
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.25f)
                    .padding(16.dp)
                    .clickable {
                        viewModel.Login(email, password)
                    },
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = olive)){
                    Text(
                        text = "Log In",
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
                
                        Text(
                            text = "First time user? Create an account",
                            fontFamily = Britannic,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            color = olive,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.2f)
                                .padding(16.dp)
                                .clickable { navController.navigate("signup_screen") }
                        )




            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController , viewModel: LogInViewModel){
    val systemUiController = rememberSystemUiController()
    val empty by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var cpassword by remember{ mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false) }
    var cpasswordVisibility by remember{ mutableStateOf(false) }
    var errorinE by remember{ mutableStateOf(false) }
    var errorinP by remember{ mutableStateOf(false) }
    var errorinCP by remember{ mutableStateOf(false) }
    systemUiController.setSystemBarsColor(
        color = olive,
        darkIcons = false
    )
    val signedIn by viewModel.SignedIn
    val inProgress by viewModel.InProgress
    LaunchedEffect(signedIn) {
        if (signedIn) {
            navController.navigate("login_screen")
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.r4), contentDescription = "", contentScale = ContentScale.Crop)

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            olive,
                            olive1,
                            transperant,
                            transperant
                        )
                    )
                )

        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            shadowElevation = 50.dp,
            shape = ShapeDefaults.Medium,
            color = Color.White
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Sign Up",
                    fontFamily = Britannic,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    color = olive,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.15f)
                        .padding(16.dp)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    TextField(value = email , onValueChange ={email = it },
                        maxLines = 1, label = { Text(text = "Email")},
                        colors = TextFieldDefaults
                            .textFieldColors(
                            containerColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                        focusedLabelColor = olive,
                        unfocusedLabelColor = olive),
                        modifier = Modifier.fillMaxSize(),
                        trailingIcon = {
                            if(email.isNotEmpty()){
                                Icon(imageVector = Icons.Default.Close, contentDescription = "" , modifier = Modifier.clickable { email = "" })
                            }
                        } ,
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")}


                    )

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    TextField(value = password , onValueChange ={password = it },
                        maxLines = 1, label = { Text(text = "Password")},
                        colors = TextFieldDefaults
                            .textFieldColors(
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                focusedLabelColor = olive,
                                unfocusedLabelColor = olive),
                        modifier = Modifier.fillMaxSize(),
                        trailingIcon = {
                            if(password.isNotEmpty()){
                                Icon(imageVector = Icons.Default.Close, contentDescription = "" , modifier = Modifier.clickable { password = "" })
                            }
                        } ,
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")}


                    )
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.25f)
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    TextField(value = cpassword , onValueChange ={cpassword = it },
                        maxLines = 1, label = { Text(text = "Confirm Password")},
                        colors = TextFieldDefaults
                            .textFieldColors(
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                focusedLabelColor = olive,
                                unfocusedLabelColor = olive),
                        modifier = Modifier.fillMaxSize(),
                        trailingIcon = {
                            if(cpassword.isNotEmpty()){
                                Icon(imageVector = Icons.Default.Close, contentDescription = "" , modifier = Modifier.clickable { cpassword = "" })
                            }
                        } ,
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")}


                    )
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                        .padding(16.dp)
                        .clickable { navController.popBackStack() },
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = olive)
                ) {
                    Text(
                        text = "Done",
                        fontFamily = Britannic,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                if (password == cpassword) {
                                    viewModel.onSignUp(email, password)
                                } else {
                                    navController.popBackStack()
                                }
                            }
                    )
                }

                




            }

        }
    }
}