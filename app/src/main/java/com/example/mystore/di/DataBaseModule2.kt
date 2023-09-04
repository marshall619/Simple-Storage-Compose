package com.example.mystore.di

import android.content.Context
import androidx.room.Room
import com.example.mystore.data.db.MyStoreDataBase2
import com.example.mystore.util.Constants.DATABASE_NAME2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object DataBaseModule2 {
    @Singleton
    @Provides
    fun provideDataBaseModule(
        @ApplicationContext context : Context
    ) = Room.databaseBuilder(
        context,
        MyStoreDataBase2 :: class.java,
        DATABASE_NAME2
    ).build()
}