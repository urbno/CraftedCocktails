package com.bme.aut.craftedcocktails.domain

import com.bme.aut.craftedcocktails.network.CocktailsNetworkDataSource
import javax.inject.Inject

class CocktailsInteractor @Inject constructor(
    private val networkDataSource: CocktailsNetworkDataSource
) {

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
}