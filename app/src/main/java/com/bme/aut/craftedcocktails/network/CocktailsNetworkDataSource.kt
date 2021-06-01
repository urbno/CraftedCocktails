package com.bme.aut.craftedcocktails.network

import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.*
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsNetworkDataSource @Inject constructor(
    private val createApi: CreateApi,
    private val deleteApi: DeleteApi,
    private val filterApi: FilterApi,
    private val lookupApi: LookupApi,
    private val searchApi: SearchApi,
    private val updateApi: UpdateApi,
    private val randomApi: RandomApi
) {

    suspend fun getCocktailByName(cocktailName: String) =
        searchApi.searchCocktailByName(cocktailName)

    suspend fun getDetailsOfCocktail(cocktailId: String) = lookupApi.getCocktailById(cocktailId)

    suspend fun deleteCocktailById(cocktailId: String) = deleteApi.deleteCocktail(cocktailId)

    suspend fun filterByAlcoholic(alcoholicType: String): Response {
        return if (alcoholicType == "Alcoholic") {
            filterApi.searchCocktailByFilter(a = "Alcoholic", i = null)
        } else {
            filterApi.searchCocktailByFilter(a = "Non_Alcoholic", i = null)
        }
    }

    suspend fun filterByIngredient(ingredient: String) =
        filterApi.searchCocktailByFilter(a = null, i = ingredient)

    suspend fun getRandomCocktail() = randomApi.getRandomCocktail()

}