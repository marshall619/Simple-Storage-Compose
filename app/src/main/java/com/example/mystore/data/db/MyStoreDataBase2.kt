package com.example.mystore.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mystore.data.model.Product2

//define and make data base
@Database(entities = [Product2::class], version = 1, exportSchema = false)
abstract class MyStoreDataBase2 : RoomDatabase() {
    abstract fun ProductDao2() : ProductDao2
}