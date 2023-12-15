package com.example.urbanquestcompose.data.repository

import com.example.urbanquestcompose.data.dao.ProductDao
import com.example.urbanquestcompose.data.models.ProductEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao) {

    suspend fun getAllProducts(): List<ProductEntity> {
        return productDao.getAllProducts()
    }

    fun insertProduct(product: ProductEntity) {
        productDao.insertProduct(product)
    }
}