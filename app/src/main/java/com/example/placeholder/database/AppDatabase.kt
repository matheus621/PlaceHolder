package com.example.placeholder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.placeholder.model.Users


@Database(entities = [Users::class], version = 2)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun Dao(): UsersDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
        }
    }

}