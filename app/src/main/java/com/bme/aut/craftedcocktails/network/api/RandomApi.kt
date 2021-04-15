package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface RandomApi {
    /**
     * Get a random cocktail
     *
     * @return Call<Response>
    </Response> */
    @GET("random.php")
    suspend fun getRandomCocktail(): Response
}