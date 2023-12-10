package com.example.urbanquestcompose.data.di

import android.content.Context
import androidx.room.Room
import com.example.urbanquestcompose.data.databases.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase = Room.databaseBuilder(context, ProductDatabase::class.java, "ProductDatabase").build()
}