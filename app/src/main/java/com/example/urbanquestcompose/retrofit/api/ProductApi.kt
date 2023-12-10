package com.example.urbanquestcompose.retrofit.api

import com.example.urbanquestcompose.data.models.ProductEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): ProductEntity
}