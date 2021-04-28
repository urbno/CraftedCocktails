package com.bme.aut.craftedcocktails

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bme.aut.craftedcocktails.data.AppDatabase
import com.bme.aut.craftedcocktails.data.CocktailDao
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CocktailsDiskDataSourceTest {

    private lateinit var cocktailDao: CocktailDao
    private lateinit var database: AppDatabase

    @Before
    fun initializingDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        cocktailDao = database.cocktailDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    fun getSavedCocktails() {
        // Todo
    }

    fun getSpecificCocktail() {
        // Todo
    }

    fun insertCocktails() {
        // Todo
    }

    fun deleteCocktail() {
        // Todo
    }

    fun deleteAllCocktails() {
        // Todo
    }
}