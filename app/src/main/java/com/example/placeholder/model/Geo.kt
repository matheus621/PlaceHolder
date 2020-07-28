package com.example.placeholder.model

import androidx.room.Entity

@Entity(tableName = "geo")
data class Geo (

    val lat : Float,
    val lng : Float
)