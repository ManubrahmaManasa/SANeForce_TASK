package com.example.saneforce_task


data class Product(
        val product_code: String,
        val product_name: String,
        var Product_Qty: Int,
        val Rate: Double,
        var Product_Amount: Double
    )

data class ProductRequest(
        val data: List<Product>
)
