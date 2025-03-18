package com.example.saneforce_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel() {

    var item = mutableListOf<Product>()

    suspend fun fetchProducts(){
        item = RetrofitInstance.api.getProducts().toMutableList()
    }

    /*suspend fun saveProducts() {
        RetrofitInstance.api.
    }*/
}