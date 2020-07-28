package com.example.placeholder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.placeholder.model.Users

@Dao
interface UsersDao {

    @Query("SELECT * FROM USERS")
    fun getAllUsers(): List<Users>

    @Query("SELECT * FROM USERS")
    fun getAllLiveUsers(): LiveData<List<Users>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSimpleUsers(users: Users)

    @Query("SELECT * FROM USERS WHERE ID = :id")
    fun getSimpleUser(id: Int) : LiveData<Users>

}