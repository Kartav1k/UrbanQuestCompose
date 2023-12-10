package com.example.urbanquestcompose.data.di

import com.example.urbanquestcompose.data.databases.ProductDatabase
import com.example.urbanquestcompose.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideProductRepository(productDatabase: ProductDatabase): ProductRepository = ProductRepository(productDatabase.productDao())
}