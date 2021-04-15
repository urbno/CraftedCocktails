package com.bme.aut.craftedcocktails.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsDiskDataSource @Inject constructor(private val cocktailDao: CocktailDao) {

    suspend fun getSavedCocktails() =
        cocktailDao.getSavedCocktails()

    suspend fun getSpecificCocktail(idDrink: String) =
        cocktailDao.getSpecificCocktail(idDrink)

    suspend fun insertCocktails(cocktail: Cocktail) =
        cocktailDao.insertCocktails(cocktail)

    suspend fun deleteCocktail(idDrink: String) =
        cocktailDao.deleteCocktail(idDrink)

    suspend fun deleteAllCocktails() =
        cocktailDao.deleteAllCocktails()
}