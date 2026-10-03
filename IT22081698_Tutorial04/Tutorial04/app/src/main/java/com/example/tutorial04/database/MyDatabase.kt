package com.example.tutorial04.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tutorial04.database.daos.MyTableDao
import com.example.tutorial04.database.entities.MyTable

@Database(entities = [MyTable::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getMyTableDao(): MyTableDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}