package com.example.placeholder.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address (

    @PrimaryKey(autoGenerate = false)
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded val geo : Geo?

    )