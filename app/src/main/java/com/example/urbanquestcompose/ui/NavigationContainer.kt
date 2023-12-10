package com.example.urbanquestcompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationContainer(navController: NavHostController) {
    NavHost(navController=navController,
        startDestination = "Registration")
    {
        composable("Registration"){
            ScreenOfRegistration(navController)
        }
        composable("ButtonHub"){
            ButtonHub(navController)
        }
        composable("Camera"){
            Camera(navController)
        }
        composable("RecView"){
            RecView(navController)
        }
        composable("DownloadPhoto"){
            DownloadPhoto(navController)
        }
        composable("Retrofit"){
            Retrofit(navController)
        }
        composable("RetrofitRecView"){

        }


    }
}