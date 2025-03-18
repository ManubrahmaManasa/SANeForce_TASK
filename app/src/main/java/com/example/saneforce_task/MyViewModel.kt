package com.example.saneforce_task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel :ViewModel() {

    var item = mutableListOf<Product>()

    suspend fun fetchProducts(){
        item = RetrofitInstance.api.getProducts().toMutableList()
    }

    fun saveProduct() {
        val products = listOf(
            Product("D111", "Arokya 150 Ml Milk", 1, 1730.0, 1730.0),
            Product("D1110", "ACKLOFEN SP 10T", 2, 100.0, 200.0)
        )

        val request = ProductRequest(products)

        viewModelScope.launch {
            try {
                RetrofitInstance.api.updateProduct(request)
                Log.d("Product_POST","Product details saved successfully")
            } catch (e: Exception) {
                Log.d("Product_POST","API Error: ${e.message}")
            }
        }
    }

}