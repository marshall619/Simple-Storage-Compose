package com.example.mystore.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mystore.data.model.Product2
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao2 {

    //insert new Product2 to table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(newProduct2 : Product2)

    @Query("select * from Product_table2")
    fun getAllProducts() : Flow<List<Product2>>

    //insert new Product2 to table
    @Query("delete from Product_table2")
    suspend fun deleteAllProducts()

    //delete one Product2
    @Query("delete from Product_table2 where id =:Product2Id ")
    suspend fun deleteProductById(Product2Id : Int)

    //update
    @Update
    suspend fun updateProduct(Product2: Product2)

    //update
    @Query("update Product_table2 set count =:newCount where id =:id")
    suspend fun updateProductById(newCount: Int , id : Int)



}