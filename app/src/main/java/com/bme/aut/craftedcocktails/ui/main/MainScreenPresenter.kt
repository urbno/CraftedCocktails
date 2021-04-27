package com.bme.aut.craftedcocktails.ui.main

import com.bme.aut.craftedcocktails.data.CocktailEntity
import com.bme.aut.craftedcocktails.domain.CocktailsInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val cocktailsInteractor: CocktailsInteractor
) {

    suspend fun getCocktailByName(cocktailName: String) =
        cocktailsInteractor.getCocktailByName(cocktailName)

    suspend fun filterByAlcoholic(alcoholicType: String) =
        cocktailsInteractor.filterByAlcoholic(alcoholicType)

    suspend fun filterByIngredient(ingredient: String) =
        cocktailsInteractor.filterByIngredient(ingredient)

    suspend fun getRandomCocktail() =
        cocktailsInteractor.getRandomCocktail()

    suspend fun getSavedCocktails() =
        cocktailsInteractor.getSavedCocktails()

    suspend fun insertCocktails(cocktail : CocktailEntity) =
        cocktailsInteractor.insertCocktails(cocktail)

    suspend fun deleteAllCocktails() =
        cocktailsInteractor.deleteAllCocktails()

    suspend fun getSpecificCocktail(idDrink: String) =
        cocktailsInteractor.getSpecificCocktail(idDrink)

    suspend fun deleteCocktail(idDrink: String) =
        cocktailsInteractor.deleteCocktail(idDrink)
}
