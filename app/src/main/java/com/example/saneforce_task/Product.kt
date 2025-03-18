package com.example.saneforce_task


import com.google.gson.annotations.SerializedName

data class Product(
        val product_code: String,
        val product_name: String,
        var Product_Qty: Int,
        val Rate: Int,
        var Product_Amount: Int
    )

data class ProductRequest(
        val data: List<Product>
)
