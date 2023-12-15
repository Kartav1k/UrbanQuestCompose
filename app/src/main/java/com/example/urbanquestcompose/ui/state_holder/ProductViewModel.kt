package com.example.urbanquestcompose.ui.state_holder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.urbanquestcompose.data.models.ProductEntity
import com.example.urbanquestcompose.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(application: Application, val productRepository: ProductRepository) : AndroidViewModel(application) {
    private val _productList = MutableStateFlow<List<ProductEntity>>(emptyList())
    val productList = _productList.asStateFlow()

    fun getAllProducts(){
        GlobalScope.launch(Dispatchers.IO) {
            _productList.value = productRepository.getAllProducts()
        }
    }
    fun insertProduct(product: ProductEntity){
        productRepository.insertProduct(product)
    }
}