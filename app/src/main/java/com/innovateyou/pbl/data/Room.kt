package com.innovateyou.pbl.data

import com.innovateyou.pbl.R

data class Room(
    val ImageResource:Int = R.drawable.r3,
    val ApartName:String = "",
    val Rating:String = "7.8",
    val Address:String = "",
    val OwnerName:String = "",
    val Price:String = "",
    val Beds:Int = 0,
    val Electricity:String = ""
)
