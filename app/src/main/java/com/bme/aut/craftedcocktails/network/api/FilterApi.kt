package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilterApi {
    /**
     * Search by filters
     * Returns a list of cocktails
     * @param a Search by alcoholic cocktail to return
     * @param i Search by ingredient in cocktail to return
     * @return Call<Response>
    </Response> */
    @GET("filter.php")
    fun searchCocktailByAlcoholic(
        @Query("a") a: String?, @Query("i") i: String?
    ): Call<Response?>?
}