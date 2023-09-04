package com.example.mystore.di

import com.example.mystore.data.db.MyStoreDataBase2
import com.example.mystore.data.db.ProductDao2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object ProductDaoModule2 {
    @Singleton
    @Provides
    fun provideProductDao(
        dataBase : MyStoreDataBase2
    ): ProductDao2 = dataBase.ProductDao2()
}