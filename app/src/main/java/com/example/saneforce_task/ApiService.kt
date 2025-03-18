package com.example.saneforce_task

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("server/native_Db_V13.php?axn=get/taskproducts&divisionCode=258")
    suspend fun getProducts():List<Product>

    @POST("server/native_Db_V13.php?axn=save/taskproddets&divisionCode=258")
    suspend fun updateProduct(@Body request:ProductRequest)
}