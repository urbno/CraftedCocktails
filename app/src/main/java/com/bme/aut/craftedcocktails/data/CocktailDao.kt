package com.bme.aut.craftedcocktails.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailDao {
    /**
     * Get the top 10 cocktails from the database
     */
    @Query("SELECT * FROM cocktail LIMIT 10")
    suspend fun getSavedCocktails(): List<CocktailEntity>

    @Query("SELECT * FROM cocktail WHERE idDrink = :idDrink")
    suspend fun getSpecificCocktail(idDrink: String): List<CocktailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktails(vararg cocktails: CocktailEntity)

    @Query("DELETE FROM cocktail WHERE idDrink = :idDrink")
    suspend fun deleteCocktail(idDrink: String)

    @Query("DELETE FROM cocktail")
    suspend fun deleteAllCocktails()
}