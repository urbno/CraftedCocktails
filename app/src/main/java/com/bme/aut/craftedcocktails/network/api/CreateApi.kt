package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.model.Cocktail
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateApi {
    /**
     * Create a new cocktail in the database
     *
     * @param body New cocktail that needs to be added to the database
     * @return Call<ApiResponse>
    </ApiResponse> */
    @POST("create.php")
    suspend fun createNewCocktail(
        @Body body: Cocktail?
    ): ApiResponse
}