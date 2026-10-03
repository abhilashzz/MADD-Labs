package com.example.tutorial04.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tutorial04.database.entities.MyTable

@Dao
interface MyTableDao {
    @Insert
    fun insert(myTable: MyTable)

    @Update
    fun update(myTable: MyTable)

    @Delete
    fun delete(myTable: MyTable)

    @Query("SELECT * FROM MyTable")
    fun getAll(): List<MyTable>

    @Query("SELECT * FROM MyTable WHERE name = :name")
    fun getOne(name: String): MyTable
}