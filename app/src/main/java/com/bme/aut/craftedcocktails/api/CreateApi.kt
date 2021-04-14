package com.bme.aut.craftedcocktails.api

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.model.Cocktail
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateApi {
    /**
     * Add a new cocktail to the database
     *
     * @param body Cocktail object that needs to be added to the database
     * @return Call<ApiResponse>
    </ApiResponse> */
    @POST("create.php")
    fun addCocktail(
        @Body body: Cocktail?
    ): Call<ApiResponse?>?
}