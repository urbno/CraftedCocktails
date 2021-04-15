package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LookupApi {
    /**
     * Lookup full cocktail details by id
     * Returns a single cocktail
     * @param i ID of cocktail to return
     * @return Call<Response>
    </Response> */
    @GET("lookup.php")
    suspend fun getCocktailById(
        @Query("i") i: String?
    ): Response
}