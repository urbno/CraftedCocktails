package com.bme.aut.craftedcocktails.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "cocktail_database").build()

    @Provides
    @Singleton
    fun provideCocktailDao(cocktailDatabase: AppDatabase) =
        cocktailDatabase.cocktailDao()
}