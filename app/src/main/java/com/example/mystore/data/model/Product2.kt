package com.example.mystore.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mystore.util.Constants.PRODUCT_TABLE
import com.example.mystore.util.Constants.PRODUCT_TABLE2

@Entity(tableName = PRODUCT_TABLE2)
data class Product2(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val discountPercent: Int,
    val name: String,
    val price: Long,
    val count: Int,
    val description : String,
    val image: String
)
