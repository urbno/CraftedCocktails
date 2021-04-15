package com.bme.aut.craftedcocktails.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CocktailDao {
    /**
     * Get the top 10 cocktails from the database
     */
    @Query("SELECT * FROM cocktail LIMIT 10")
    suspend fun getSavedCocktails(): List<Cocktail>

    @Query("SELECT * FROM cocktail WHERE idDrink = :idDrink")
    suspend fun getSpecificCocktail(idDrink: String): List<Cocktail>

    @Insert
    suspend fun insertCocktails(vararg cocktails: Cocktail)

    @Query("DELETE FROM cocktail WHERE idDrink = :idDrink")
    suspend fun deleteCocktail(idDrink: String)

    @Query("DELETE FROM cocktail")
    suspend fun deleteAllCocktails()
}