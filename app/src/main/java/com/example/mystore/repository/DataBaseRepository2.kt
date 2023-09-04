package com.example.mystore.repository

import com.example.mystore.data.db.ProductDao2
import com.example.mystore.data.model.Product2
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataBaseRepository2 @Inject constructor(
    val dao : ProductDao2
) {
    val allProducts : Flow<List<Product2>> = dao.getAllProducts()

    suspend fun insetProduct(newProduct: Product2){
        dao.insertProduct(newProduct)
    }

    suspend fun deleteAllProducts(){
        dao.deleteAllProducts()
    }

    suspend fun deleteProductById(productId : Int){
        dao.deleteProductById(productId)
    }

    suspend fun updateProduct(product: Product2){
        dao.updateProduct(product)
    }

    suspend fun updateProductById(newCount: Int , id : Int){
        dao.updateProductById(newCount , id)
    }

}