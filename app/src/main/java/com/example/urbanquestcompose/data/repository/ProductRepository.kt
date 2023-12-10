package com.example.urbanquestcompose.data.repository

import androidx.lifecycle.LiveData
import com.example.urbanquestcompose.data.dao.ProductDao
import com.example.urbanquestcompose.data.models.ProductEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao) {

    fun getAllProducts(): LiveData<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    fun insertProduct(product: ProductEntity) {
        productDao.insertProduct(product)
    }
}