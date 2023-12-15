package com.example.urbanquestcompose.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.urbanquestcompose.retrofit.api.ProductApi
import com.example.urbanquestcompose.ui.state_holder.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun Retrofit(navController: NavHostController, productViewModel: ProductViewModel) {
    var idField by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }

    val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val productApi = retrofit.create(ProductApi::class.java)

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        item {
            OutlinedTextField(
                value = idField,
                onValueChange = { idField = it },
                label = { Text("Введите ID") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Button(
                onClick = {
                    if(idField.isNotEmpty()){
                        errorMsg = ""
                        val id = idField.toInt()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val product = productApi.getProductById(id)
                                productViewModel.insertProduct(product)
                                withContext(Dispatchers.Main) {
                                    title=product.title
                                    description=product.description
                                    Log.d("Room", "Product inserted into the database: $product")
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                    else {
                        errorMsg = "Ошибка, введите целое число!"
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text("Загрузить", color = Color(0xFF86C98A))
            }
            Button(
                onClick = {
                    navController.navigate("RetrofitRecView")
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text("Список", color = Color(0xFF86C98A))
            }
            Text(text = title, color= Color.Black)
            Text(text = description, color= Color.Black)
            Text(text= errorMsg, color = Color.Red)
        }

    }

}