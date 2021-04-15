package com.bme.aut.craftedcocktails.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cocktail::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao
}