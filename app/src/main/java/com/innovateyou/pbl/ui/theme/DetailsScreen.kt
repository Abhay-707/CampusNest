package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavType
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.innovateyou.pbl.R


@Composable
fun RoomDetailsScreen(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val ImgResourceString = navBackStackEntry.arguments?.getString("ImageResource")
    val roomName = navBackStackEntry.arguments?.getString("RoomName")
    val rating = navBackStackEntry.arguments?.getString("Rating")
    val address = navBackStackEntry.arguments?.getString("Address")
    val ownerName = navBackStackEntry.arguments?.getString("OwnerName")
    val price = navBackStackEntry.arguments?.getString("Price")
    val beds = navBackStackEntry.arguments?.getInt("Beds")
    val electricity = navBackStackEntry.arguments?.getString("Electricity")
    val items = arrayOf("Image", "details", "contact", "gallery" ,"footer")
    val ImgResource = ImgResourceString?.toIntOrNull() ?: R.drawable.r1
    val name = roomName.toString()
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    val view = LocalView.current
    val density = LocalDensity.current.density
    val galleryImg = arrayOf(R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6,R.drawable.r7,R.drawable.r8,)

    systemUiController.setSystemBarsColor(
        color = olive,
        darkIcons = false
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(yellow)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentPadding = PaddingValues(0.dp)
        ) {
            items(items.size) { index ->
                val item = items[index]
                when (item) {
                    "Image" -> {
                        key(item) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(380.dp)
                            ) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Black.copy(alpha = 0.6f),
                                                    Color.Transparent
                                                ),
                                                startY = 0f,
                                                endY = 150f
                                            )
                                        )
                                        .clip(
                                            RoundedCornerShape(
                                                bottomEndPercent = 8,
                                                bottomStartPercent = 8
                                            )
                                        )
                                ) {
                                    val painter = rememberAsyncImagePainter(
                                            ImageRequest.Builder(LocalContext.current)
                                                .data(ImgResource)
                                                .build()
                                            )

                                    Image(
                                        painter = painter,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

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
                                            .clip(
                                                RoundedCornerShape(
                                                    bottomEndPercent = 8,
                                                    bottomStartPercent = 8
                                                )
                                            )
                                    )

                                    Card(
                                        Modifier
                                            .align(Alignment.TopStart)
                                            .padding(16.dp)
                                            .clip(RoundedCornerShape(50))
                                            .height(50.dp)
                                            .clickable { navController.popBackStack() }
                                            .width(50.dp),
                                        colors = CardDefaults.cardColors(containerColor = White1)) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.back),
                                                contentDescription = "",
                                                modifier = Modifier.padding(
                                                    start = 16.dp,
                                                    end = 20.dp
                                                )
                                            )
                                        }

                                    }
                                    Card(
                                        Modifier
                                            .align(Alignment.TopEnd)
                                            .padding(16.dp)
                                            .clip(RoundedCornerShape(50))
                                            .height(50.dp)
                                            .width(50.dp),
                                        colors = CardDefaults.cardColors(containerColor = White1)) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                text = rating.toString(),
                                                fontFamily = Britannic,
                                                color = yellowish
                                            )
                                        }


                                    }
                                }


                            }
                        }
                    }

                    "details" -> {
                        key(item) {
                            Card (modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) , colors = CardDefaults.cardColors(containerColor = Color.White)){
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp)
                                        .height(380.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(0.1f),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = name,
                                            fontFamily = Britannic,
                                            fontSize = 24.sp,
                                            color = olive
                                        )
                                        Text(
                                            text = "Rs.$price/month",
                                            fontFamily = Britannic,
                                            fontSize = 18.sp,
                                            color = olive
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(0.1f),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.LocationOn,
                                            contentDescription = "Address",
                                            tint = olive
                                        )
                                        Text(
                                            text = address.toString(),
                                            fontFamily = Britannic,
                                            fontSize = 16.sp,
                                            color = Color.Gray , maxLines = 1
                                        )

                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(0.1f)
                                            .padding(8.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Card(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding()
                                                .weight(0.1f),
                                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), colors = CardDefaults.cardColors(olive)

                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .weight(0.1f),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.sleeping),
                                                    contentDescription = "beds",
                                                    modifier = Modifier.size(30.dp)
                                                )
                                                Text(text = if( beds == 1){"${beds} Bed"}else{"${beds} Beds"}, fontFamily = Britannic , modifier = Modifier.padding(4.dp) , color = Color.White)

                                            }
                                        }
                                        Card(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(start = 16.dp)
                                                .weight(0.1f),
                                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), colors = CardDefaults.cardColors(olive)

                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .weight(0.1f),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.plug),
                                                    contentDescription = "beds",
                                                    modifier = Modifier.size(30.dp)
                                                )
                                                Text(text = electricity.toString() , fontFamily = Britannic , modifier = Modifier.padding(4.dp), color = Color.White)

                                            }
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()

                                            .weight(0.3f),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {

                                            Text(
                                                text = "Welcome to our welcoming city hostel, where affordability meets comfort. Choose from shared dorms or private rooms, all designed with your relaxation in mind. Enjoy complimentary breakfast, swap travel tales in our cozy lounge, and let our friendly staff guide you to the best local spots. Join us for an unforgettable stay!",
                                                fontFamily = Britannic,
                                                fontSize = 14.sp,
                                                color = Color.Gray,
                                                textAlign = TextAlign.Start,
                                                modifier = Modifier.padding(8.dp)
                                            )


                                    }
                            }


                            }

                        }
                    }
                    "contact"->{
                        key(item){
                            Card (modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) , colors = CardDefaults.cardColors(containerColor = Color.White), shape = ShapeDefaults.ExtraLarge){
                                Row(modifier = Modifier
                                    .fillMaxSize()
                                    .height(100.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    FloatingActionButton(onClick = { /*TODO*/ } , modifier = Modifier
                                        .weight(0.25f)
                                        .padding(16.dp)
                                        .clip(RoundedCornerShape(50))
                                        .width(60.dp)
                                        .height(70.dp),
                                        containerColor = yellow) {
                                        Image(painter = painterResource(id = R.drawable.man), contentDescription = "owner photo", contentScale = ContentScale.Inside)
                                    }
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 16.dp)
                                        .weight(0.5f), verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.Start){
                                        Text(text = ownerName.toString()  , fontFamily = Britannic , color = olive, fontSize = 24.sp , textAlign = TextAlign.Start)
                                        Text(text = "Owner $name"  , fontFamily = Britannic , color = Color.Gray, fontSize = 12.sp , textAlign = TextAlign.Start , maxLines = 1)
                                    }

                                    FloatingActionButton(onClick = { /*TODO*/ } , modifier = Modifier
                                        .weight(0.25f)
                                        .padding(16.dp)
                                        .clip(RoundedCornerShape(50))
                                        .width(0.dp)
                                        .height(70.dp),
                                        containerColor = olive) {
                                        Icon(imageVector = Icons.Default.Phone, contentDescription = "", tint = Color.White)

                                    }

                                }

                            }
                        }

                    }
                    "gallery"->{
                        key(item){
                            Card (modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 8.dp, bottom = 8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) , colors = CardDefaults.cardColors(containerColor = Color.White)){
                                Column(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp), verticalArrangement = Arrangement.Top , horizontalAlignment = Alignment.Start){
                                    Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                                        Text(text = "Gallery", fontSize = 32.sp , fontFamily = Britannic , color = olive , modifier = Modifier.padding(16.dp) )
                                        Image(painter = painterResource(id = R.drawable.camera), contentDescription = "gallery" , modifier = Modifier.padding(24.dp).width(40.dp).height(40.dp))
                                    }

                                    LazyRow(modifier = Modifier.padding(8.dp)){
                                        items(galleryImg.size){img ->
                                            GalleryCard(id = galleryImg[img])

                                        }
                                    }

                                }
                            }
                        }
                    }
                    /*"footer"->{
                        key(item){
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)){

                            }
                        }
                    }*/


                }

            }
        }

        /*Card(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp).clip(RoundedCornerShape(topStartPercent = 20 , topEndPercent = 20 , bottomEndPercent = 0 , bottomStartPercent = 0))
            .align(Alignment.BottomCenter), shape = ShapeDefaults.ExtraLarge , elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) , colors = CardDefaults.cardColors(containerColor = Color.White)){

        }*/
    }
}







