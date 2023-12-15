package com.example.urbanquestcompose.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.urbanquestcompose.ui.state_holder.ProductViewModel
import com.example.urbanquestcompose.ui.state_holder.RegistrationViewModel

@Composable
fun NavigationContainer(navController: NavHostController) {
    val viewModel: RegistrationViewModel= viewModel()
    val productViewModel: ProductViewModel = viewModel()
    NavHost(navController=navController,
        startDestination = "Registration")
    {
        composable("Registration"){
            ScreenOfRegistration(navController, viewModel)
        }
        composable("ButtonHub"){
            ButtonHub(navController, viewModel)
        }
        /*composable("Camera"){
            Camera(navController)
        }*/
        composable("RecView"){
            RecView(navController)
        }
        composable("DownloadPhoto"){
            DownloadPhoto(navController)
        }
        composable("Retrofit"){
            Retrofit(navController, productViewModel)
        }
        composable("RetrofitRecView"){
            RetrofitRecView(navController, productViewModel)
        }
    }
}