package com.example.urbanquestcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(@PrimaryKey val id: Int, val title: String, val description: String)
