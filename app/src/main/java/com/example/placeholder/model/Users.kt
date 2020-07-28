package com.example.placeholder.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val email: String,
    @Embedded val address: Address?,
    val phone: String,
    val website: String,
    @Embedded val company: Company?

)
