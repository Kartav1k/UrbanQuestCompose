package com.example.urbanquestcompose.ui

import android.os.Environment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.urbanquestcompose.data.models.RecViewElementOfData
import java.io.File

@Composable
fun RecView(navController: NavHostController) {
    val recView by remember {
        mutableStateOf(loadDatesFromFile())
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(items=recView){
            Text(text=it.date)
        }
    }
}
private fun loadDatesFromFile(): List<RecViewElementOfData> {
    val dir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "photos")
    val fileName = File(dir, "date.txt")
    val dateItems = mutableListOf<RecViewElementOfData>()
    if (fileName.exists()) {
        val lines = fileName.readLines()
        for (line in lines) {
            dateItems.add(RecViewElementOfData(line))
        }
    }
    return dateItems
}