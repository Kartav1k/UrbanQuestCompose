package com.example.urbanquestcompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.urbanquestcompose.ui.state_holder.ProductViewModel


@Composable
fun RetrofitRecView(navController: NavHostController, productViewModel: ProductViewModel) {
    productViewModel.getAllProducts()
    val recView=productViewModel.productList.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(items=recView.value){
            Text(text=it.id.toString())
            Text(text=it.title)
            Text(text=it.description)
        }
    }
}