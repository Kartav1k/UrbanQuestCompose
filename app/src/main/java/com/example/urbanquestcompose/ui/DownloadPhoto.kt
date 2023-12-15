package com.example.urbanquestcompose.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

@Composable
fun DownloadPhoto(navController: NavHostController) {
    val imageUrl = "https://sportishka.com/uploads/posts/2022-11/1667563774_8-sportishka-com-p-priroda-kitaya-krasivo-8.jpg"
    var url by remember { mutableStateOf(imageUrl) }
    var _bitmap = MutableStateFlow<ImageBitmap?>(null)
    var bitmap= _bitmap.collectAsState()
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Загрузка фотографии",
                color = Color.Green,
                fontSize = 34.sp,
                modifier = Modifier
                    .padding(top = 32.dp)
            )

            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("Фамилия") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
            if (bitmap.value!=null){
                Image(bitmap = bitmap.value!!, contentDescription = " ")
            }

            Button(
                onClick = {
                    GlobalScope.launch(Dispatchers.IO) {
                        _bitmap.value = downloadImage(imageUrl)
                        if(bitmap.value!=null){
                            val savedImagePath = saveImageToDisk(bitmap.value!!, context)
                        }
                    }
                },
                modifier = Modifier
                    .padding(top = 24.dp)
            ) {
                Text("Загрузить", color = Color(0xFF86C98A))
            }
        }
    }


}

fun downloadImage(imageUrl: String): ImageBitmap {
    val url = URL(imageUrl)
    val connection = url.openConnection() as HttpURLConnection
    connection.connect()
    val inputStream: InputStream = connection.inputStream
    val bitmap = BitmapFactory.decodeStream(inputStream)
    return bitmap.asImageBitmap()
}

fun saveImageToDisk(imageBitmap: ImageBitmap, context: Context): String {
    val fileName = "downloaded_image.png"
    val imageFile = File(context.getExternalFilesDir(null), fileName)
    val outputStream = FileOutputStream(imageFile)
    imageBitmap.asAndroidBitmap().compress(Bitmap.CompressFormat.PNG, 100, outputStream)
    outputStream.close()
    return imageFile.absolutePath
}