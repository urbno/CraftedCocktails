package com.bme.aut.craftedcocktails.domain

import com.bme.aut.craftedcocktails.data.CocktailEntity
import com.bme.aut.craftedcocktails.data.CocktailsDiskDataSource
import com.bme.aut.craftedcocktails.network.CocktailsNetworkDataSource
import javax.inject.Inject

class CocktailsInteractor @Inject constructor(
    private val networkDataSource: CocktailsNetworkDataSource,
    private val diskDataSource: CocktailsDiskDataSource
) {

    // region networkDataSource

    suspend fun getCocktailByName(cocktailName: String) =
        networkDataSource.getCocktailByName(cocktailName)

    suspend fun getDetailsOfCocktail(cocktailId: String) =
        networkDataSource.getDetailsOfCocktail(cocktailId)

    suspend fun deleteCocktailById(cocktailId: String) =
        networkDataSource.deleteCocktailById(cocktailId)

    suspend fun filterByAlcoholic(alcoholicType: String) =
        networkDataSource.filterByAlcoholic(alcoholicType)

    suspend fun filterByIngredient(ingredient: String) =
        networkDataSource.filterByIngredient(ingredient)

    suspend fun getRandomCocktail() =
        networkDataSource.getRandomCocktail()

    // endregion

    // region diskDataSource

    suspend fun getSavedCocktails() =
        diskDataSource.getSavedCocktails()

    suspend fun getSpecificCocktail(idDrink: String) =
        diskDataSource.getSpecificCocktail(idDrink)

    suspend fun insertCocktails(cocktails: CocktailEntity) =
        diskDataSource.insertCocktails(cocktails)

    suspend fun deleteCocktail(idDrink: String) =
        diskDataSource.deleteCocktail(idDrink)

    suspend fun deleteAllCocktails() =
        diskDataSource.deleteAllCocktails()

    // endregion
}