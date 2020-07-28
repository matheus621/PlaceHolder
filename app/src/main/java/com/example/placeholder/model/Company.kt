package com.example.placeholder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "company_name")
    val name: String,
    val catchPhrase: String,
    val bs: String

)
