package com.example.urbanquestcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.urbanquestcompose.data.models.UserData
import com.example.urbanquestcompose.ui.state_holder.RegistrationViewModel
import java.util.concurrent.TimeUnit


@Composable
fun ButtonHub(navController: NavHostController, viewModel: RegistrationViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        val user: UserData by remember { mutableStateOf(viewModel.userLiveData)}
        val surname = user.surname
        val name = user.name

        Text(text = "Здравствуйте, " + surname +" "+  name,
            modifier = Modifier
                .padding(top=16.dp)
        )
        /*Button(
            onClick={
                navController.navigate("Camera")
            },
            modifier = Modifier
                .padding(top = 128.dp)
                .width(196.dp)
        ){
            Text("Camera", color = Color.Black)
        }*/
        Button(
            onClick={
                navController.navigate("RecView")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(196.dp)
        ){
            Text("История фото", color = Color.Black)
        }
        Button(
            onClick={
                navController.navigate("DownloadPhoto")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(196.dp)
        ){
            Text("Загрузка фото", color = Color.Black)
        }
        Button(
            onClick={
                navController.navigate("Retrofit")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(196.dp)
        ){
            Text("Retrofit", color = Color.Black)
        }
        Button(
            onClick={
                val workRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
                    .setInitialDelay(10, TimeUnit.SECONDS)
                    .build()
                WorkManager.getInstance().enqueue(workRequest)
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(196.dp)
        ){
            Text("Уведомление", color = Color.Black)
        }
    }
}