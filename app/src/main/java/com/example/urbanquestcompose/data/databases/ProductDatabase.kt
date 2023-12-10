package com.example.urbanquestcompose.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.urbanquestcompose.data.dao.ProductDao
import com.example.urbanquestcompose.data.models.ProductEntity

@Database(version = 1, entities = [ProductEntity::class])
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
    /*companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "ProductDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}