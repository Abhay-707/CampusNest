package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.innovateyou.pbl.R
import com.innovateyou.pbl.data.Room

var roomList = listOf(
    Room(
        R.drawable.r1,
        "Sapphire Residency",
        "4.2",
        "23 Sunshine Avenue, Tranquil Meadows, Lohgaon ",
        "John Doe",
        "5900",
        4,
        "Included"
    ),
    Room(
        R.drawable.r2,
        "Emerald  Hostel",
        "3.6",
        "456 Skyline Street, Horizon Heights, Lohgaon",
        "John Doe",
        "6500",
        3,
        "Excluded"
    ),
    Room(
        R.drawable.r3,
        "Pearl Gardens",
        "4.7",
        "789 Meadow Lane, Whispering Woods, Lohgaon",
        "John Doe",
        "6800",
        1,
        "Excluded"
    ),
    Room(
        R.drawable.r4,
        "Diamond Hostel",
        "4.5",
        "01 Serenity Road, Harmony Gardens, Lohgaon",
        "John Doe",
        "7200",
        5,
        "Included"
    ),
    Room(
        R.drawable.r5,
        "Room Complex",
        "4.3",
        "222 Maple Court, Blissful Breeze, Lohgaon",
        "John Doe",
        "7500",
        2,
        "Excluded"
    ),
    Room(
        R.drawable.r6,
        "Ruby Apartments",
        "3.9",
        "333 Sunset Boulevard, Golden Glade, Lohgaon",
        "John Doe",
        "5500",
        3,
        "Included"
    ),
    Room(
        R.drawable.r2,
        "Topaz Inn",
        "4.4",
        "444 Riverside Drive, Emerald Enclave, Lohgaon",
        "John Doe",
        "6300",
        3,
        "Included"
    ),
    Room(
        R.drawable.r8,
        "Amethyst Lodge",
        "4.8",
        "555 Forest Avenue, Tranquility Terrace, Lohgaon",
        "John Doe",
        "6700",
        4,
        "Excluded"
    )
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindApartment(navController: NavController, viewModel: LogInViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {
        var BudgetExpanded by remember { mutableStateOf(false) }
        var ElectricityExpanded by remember { mutableStateOf(false) }
        var MateExpanded by remember { mutableStateOf(false) }
        var TextFieldEnabled by remember { mutableStateOf(false) }
        var SearchIcon by remember { mutableStateOf(Icons.Default.Search) }
        var typing by remember { mutableStateOf(false) }
        val Query = remember { mutableStateOf("") }
        var selectedBudget by remember { mutableStateOf("") }
        var selectedElectricity by remember { mutableStateOf("") }
        var selectedRoommates by remember { mutableStateOf("") }

        val filteredRoomList = roomList.filter { room ->
            val nameMatch = if (Query.value.isBlank()) {
                true
            } else {
                room.ApartName.contains(Query.value, ignoreCase = true)
            }

            val budgetMatch = when (selectedBudget) {
                "<5000" -> room.Price.toInt() < 5000
                "5000-6000" -> room.Price.toInt() in 5000..6000
                "6000-7000" -> room.Price.toInt() in 6000..7000
                "7000-8000" -> room.Price.toInt() in 7000..8000
                else -> true // No budget filter applied
            }

            val electricityMatch = if (selectedElectricity.isBlank() || selectedElectricity == "Any") {
                true
            } else {
                room.Electricity == selectedElectricity
            }

            val roommatesMatch = if (selectedRoommates.isBlank()) {
                true
            } else {
                room.Beds.toString() <= selectedRoommates
            }

            nameMatch && budgetMatch && electricityMatch && roommatesMatch
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 2.dp, bottom = 2.dp)
                .weight(0.1f), verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier
                .fillMaxSize()
                .weight(80f)
                .padding(start = 8.dp, end = 8.dp) , elevation = CardDefaults.cardElevation(10.dp), shape = ShapeDefaults.Small){
                TextField(value = Query.value, onValueChange = { Query.value = it }, modifier = Modifier
                    .fillMaxSize()
                    .clickable { TextFieldEnabled = true }

                    .clip(RoundedCornerShape(10)),
                    colors = TextFieldDefaults
                        .textFieldColors(
                            containerColor = yellow,
                            unfocusedIndicatorColor = yellow,
                            focusedIndicatorColor = yellow, disabledIndicatorColor = yellow,
                            focusedLabelColor = olive,
                            unfocusedLabelColor = olive
                        ),
                    textStyle = TextStyle(
                        fontFamily = Britannic,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    ),
                    label = {
                        Text(
                            text = "Search",
                            fontFamily = Britannic,
                            textAlign = TextAlign.Center
                        )
                    }, enabled = TextFieldEnabled
                )
            }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
                    .clickable {
                        if (TextFieldEnabled) {
                            TextFieldEnabled = false
                            SearchIcon = Icons.Default.Search
                            Query.value = ""
                        }
                    }
                    .height(100.dp)
                    .background(color = Color.White)
                    .weight(20f),
                colors = CardDefaults.cardColors(containerColor = olive)

            ) {
                if (TextFieldEnabled) {
                    SearchIcon = Icons.Default.Close
                }
                Icon(
                    imageVector = SearchIcon,
                    contentDescription = "Search",
                    tint = SearchColor,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )

            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, top = 16.dp)
                .weight(0.05f)
        ) {
            Text(
                text = "Nearby",
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = Britannic,
                color = Color.Gray
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp)
                .weight(0.6f)
        ) {
            LazyRow(modifier = Modifier.fillMaxSize()) {
                items(filteredRoomList) { room ->
                    LazyRowCard(
                        navController = navController,
                        ImgResource = room.ImageResource,
                        RoomName = room.ApartName,
                        Rating = room.Rating,
                        Address = room.Address,
                        OwnerName = room.OwnerName,
                        Price = room.Price,
                        Beds = room.Beds,
                        Electricity = room.Electricity
                    ) {
                        navController.navigate("room_details_screen/${room.ImageResource}/${room.ApartName}/${room.Rating}/${room.Address}/${room.OwnerName}/${room.Price}/${room.Beds}/${room.Electricity}")
                    }

                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(0.05f)
        ) {
            Text(
                text = "Set Preferences",
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = Britannic,
                color = Color.Gray
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(0.1f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp)
                    , elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.7f)
                            .background(olive)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Set Budget",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = Britannic,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(0.3f)
                        .background(yellow)
                        .clickable { BudgetExpanded = true }) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = viewModel.Budget.value ,
                                    fontFamily = Britannic,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowUp,
                                    contentDescription = "Selct Budget"
                                )

                            }
                            DropdownMenu(
                                expanded = BudgetExpanded,
                                onDismissRequest = { BudgetExpanded = false },
                                modifier = Modifier.background(yellow)) {
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "<5000",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center,

                                    )
                                },
                                    onClick = {
                                        BudgetExpanded = false
                                        viewModel.Budget.value = "<5000"
                                        selectedBudget = "<5000"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "5000-6000",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        BudgetExpanded = false
                                        viewModel.Budget.value  = "5000-6000"
                                        selectedBudget = "5000-6000"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "6000-7000",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        BudgetExpanded = false
                                        viewModel.Budget.value  = "6000-7000"
                                        selectedBudget = "6000-7000"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "7000-8000",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        BudgetExpanded = false
                                        viewModel.Budget.value  = "7000-8000"
                                        selectedBudget = "7000-8000"
                                    }, modifier = Modifier.background(yellow))

                            }
                        }

                    }

                }

            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(0.1f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp)
                , elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.7f)
                            .background(olive)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Electricity Bill",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = Britannic,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(0.3f)
                        .background(yellow)
                        .clickable { ElectricityExpanded = true }) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = viewModel.Electricity.value,
                                    fontFamily = Britannic,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowUp,
                                    contentDescription = "Selct Budget"
                                )

                            }
                            DropdownMenu(
                                expanded = ElectricityExpanded,
                                onDismissRequest = { ElectricityExpanded = false },
                                modifier = Modifier.background(yellow)) {
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "Yes",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        ElectricityExpanded = false
                                        viewModel.Electricity.value = "Included"
                                        selectedElectricity ="Included"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "No",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        ElectricityExpanded = false
                                        viewModel.Electricity.value = "Excluded"
                                        selectedElectricity ="Excluded"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "Any",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        ElectricityExpanded = false
                                        viewModel.Electricity.value = "Both"
                                        selectedElectricity ="Both"
                                    }, modifier = Modifier.background(yellow))


                            }
                        }

                    }

                }

            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(0.1f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp)
                , elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.7f)
                            .background(olive)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No. of Beds",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = Britannic,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(0.3f)
                        .background(yellow)
                        .clickable { MateExpanded = true }) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = viewModel.Mate.value ,
                                    fontFamily = Britannic,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowUp,
                                    contentDescription = "Selct Budget"
                                )

                            }
                            DropdownMenu(
                                expanded = MateExpanded,
                                onDismissRequest = { MateExpanded = false },
                                modifier = Modifier.background(yellow)) {
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "1",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        MateExpanded = false
                                        viewModel.Mate.value  = "Single"
                                        selectedRoommates = "1"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "2",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        MateExpanded = false
                                        viewModel.Mate.value = "two"
                                        selectedRoommates = "2"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "3",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        MateExpanded = false
                                        viewModel.Mate.value  = "three"
                                        selectedRoommates = "3"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "4",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        MateExpanded = false
                                        viewModel.Mate.value  = "four"
                                        selectedRoommates = "4"
                                    }, modifier = Modifier.background(yellow))
                                DropdownMenuItem(text = {
                                    Text(
                                        text = "5",
                                        fontFamily = Britannic,
                                        textAlign = TextAlign.Center
                                    )
                                },
                                    onClick = {
                                        MateExpanded = false
                                        viewModel.Mate.value  = "five"
                                        selectedRoommates = "5"
                                    }, modifier = Modifier.background(yellow))

                            }
                        }

                    }

                }

            }


        }


    }

}

