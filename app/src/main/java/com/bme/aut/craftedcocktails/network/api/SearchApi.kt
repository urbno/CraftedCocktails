package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    /**
     * Search cocktail by name
     * Returns a single cocktail
     * @param s Name of cocktail to return
     * @return Call<Response>
    </Response> */
    @GET("search.php")
    fun searchCocktailByName(
        @Query("s") s: String?
    ): Call<Response?>?
}