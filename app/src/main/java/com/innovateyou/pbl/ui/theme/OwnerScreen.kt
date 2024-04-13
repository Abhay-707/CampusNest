package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.innovateyou.pbl.R
import androidx.compose.runtime.key
import com.innovateyou.pbl.data.Room

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoom(navController: NavController , viewModel: LogInViewModel , onAddApartment: () -> Unit = {}){
    var addedRoomName by viewModel.add_roomName
    var addedOwnerName by viewModel.add_ownerName
    var addedAddress by viewModel.add_address
    var addedDescription by viewModel.add_description
    var addedRent by viewModel.add_Rent
    var addedBeds by viewModel.add_beds
    var addedElectricity by viewModel.add_electricity
    val items = arrayOf("NameField","MainImage","OwnerName","Rent","Beds","Electricity","Address","Description","Gallery","Add")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(yellow)){
        Column(modifier = Modifier
            .fillMaxSize()
        ){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(olive)){
                Text(text = "List your place", color = Color.White , fontFamily = Britannic , modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center, fontSize =32.sp)
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), contentPadding = PaddingValues(0.dp)
            ) {
                items(items.size) { index ->
                    val item = items[index]
                    when (item) {
                        "NameField"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(16.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedRoomName , onValueChange ={addedRoomName = it },
                                        maxLines = 1, label = { Text(text = "Name", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "MainImage"->{
                            key(item){
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(200.dp)
                                        .background(color = Color.White)
                                        .clickable {},
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    )
                                ){
                                    Icon(painter = painterResource(id = R.drawable.baseline_add_box_24), contentDescription = "" , modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp))
                                    Text(text = "Add Image"
                                        ,fontFamily = Britannic,
                                        textAlign = TextAlign.Center,
                                        fontSize = 32.sp,
                                        color = olive
                                    )
                                }
                            }
                        }
                        "OwnerName"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(80.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedOwnerName , onValueChange ={addedOwnerName = it },
                                        maxLines = 1, label = { Text(text = "Owner Name", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "Rent"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(80.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedRent , onValueChange ={addedRent = it },
                                        maxLines = 1, label = { Text(text = "Rent/mon", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "Beds"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(80.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedBeds , onValueChange ={addedBeds = it },
                                        maxLines = 1, label = { Text(text = "No. of beds", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "Electricity"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(150.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    Text(text = "Electricity Bill", fontFamily = Britannic)
                                    Row {
                                        Text(
                                            text = "Included", fontFamily = Britannic,
                                            modifier = Modifier.clickable { addedElectricity = "Included" })
                                        Spacer(modifier = Modifier.fillMaxHeight().width(100.dp))
                                        Text(
                                            text = "Excluded", fontFamily = Britannic,
                                            modifier = Modifier.clickable { addedElectricity = "Excluded" })
                                    }
                                }
                            }
                        }
                        "Address"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(100.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedAddress , onValueChange ={addedAddress = it },
                                        maxLines = 1, label = { Text(text = "Address", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "Description"->{
                            key(item){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(100.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    TextField(value = addedDescription , onValueChange ={addedDescription = it },
                                        maxLines = 1, label = { Text(text = "Describe your place", fontFamily = Britannic) },
                                        visualTransformation = VisualTransformation.None,
                                        colors = TextFieldDefaults
                                            .textFieldColors(
                                                containerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White, disabledIndicatorColor = Color.White,
                                                focusedLabelColor = olive,
                                                unfocusedLabelColor = olive
                                            ),
                                        modifier = Modifier.fillMaxSize(),
                                    )
                                }
                            }
                        }
                        "Gallery"->{
                            key(item){
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(100.dp)
                                        .background(color = Color.White)
                                        .clickable {},
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    )
                                ){
                                    Icon(painter = painterResource(id = R.drawable.baseline_add_box_24), contentDescription = "" , modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp))
                                    Text(text = "Add Image"
                                        ,fontFamily = Britannic,
                                        textAlign = TextAlign.Center,
                                        fontSize = 32.sp,
                                        color = olive
                                    )
                                }
                            }
                        }
                       "Add"->{
                           key(item){
                               Card(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .padding(16.dp)
                                       .clickable { },
                                   elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                   colors =
                                   CardDefaults.cardColors(containerColor = olive)
                               ){Text(
                                   text = "Add",
                                   fontFamily = Britannic,
                                   fontSize = 18.sp,
                                   textAlign = TextAlign.Center,
                                   color = Color.White,
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .padding(16.dp)
                                       .clickable
                                       {
                                           val apartment = Room(
                                               ApartName = addedRoomName ,
                                               OwnerName = addedOwnerName,
                                               Address = addedAddress,
                                               Price = addedRent,
                                               Beds = addedBeds.toIntOrNull() ?:1,
                                               Electricity = addedElectricity
                                           )
                                           viewModel.addApartment(apartment)
                                           onAddApartment()
                                           viewModel.signOut()
                                       }
                               )}
                           }
                       }
                    }
                }

            }
        }
    }
}


@Composable
fun addedRoomScreen(){

}