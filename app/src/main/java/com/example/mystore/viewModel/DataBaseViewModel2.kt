package com.example.mystore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystore.data.model.Product2
import com.example.mystore.repository.DataBaseRepository2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataBaseViewModel2 @Inject constructor(
    private val repository: DataBaseRepository2
) : ViewModel() {

    val allProducts : Flow<List<Product2>> = repository.allProducts

    fun insertProduct(newProduct: Product2){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insetProduct(newProduct)
        }
    }

    fun deleteAllProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllProducts()
        }
    }

    fun deleteProductById(productId : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProductById(productId)
        }
    }

    fun updateProduct(product: Product2){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(product)
        }
    }

    fun updateProductById(newCount: Int , id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProductById(newCount , id)
        }
    }

}