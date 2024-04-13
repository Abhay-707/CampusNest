package com.innovateyou.pbl.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.innovateyou.pbl.R

@Composable
fun LazyRowCard(
    navController: NavController,
    ImgResource: Int,
    RoomName: String,
    Rating: String,
    Address: String,
    OwnerName: String,
    Price: String,
    Beds:Int,
    Electricity:String,
    onClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        modifier = Modifier
            .width(380.dp)
            .height(400.dp)
            .padding(10.dp)
            .clickable { }
            .background(color = Color.White)
            .clickable {
                // Navigate to the new screen when the LazyRow item is clicked
                onClick()
            }
        ,
        colors = CardDefaults.cardColors(containerColor = yellow),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(yellow)
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
        }

        Box(
            modifier = Modifier
                .weight(0.4f)
                .weight(0.4f)
                .background(olive)
        ) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.3f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = RoomName,
                            color = Color.White, fontSize = 20.sp, fontFamily = Britannic
                        )
                        Text(
                            text = "$Rating/5.0",
                            color = yellowish,
                            fontSize = 20.sp,
                            fontFamily = Britannic
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.4f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = Address,
                            color = yellow,
                            fontSize = 16.sp,
                            fontFamily = Britannic
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.3f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = OwnerName,
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = Britannic
                        )
                        Text(
                            text = "Rs.$Price/month",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = Britannic
                        )

                    }


                }


            }
        }

    }
}

