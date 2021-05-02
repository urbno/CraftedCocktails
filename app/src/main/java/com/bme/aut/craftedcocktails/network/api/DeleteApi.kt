package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.ApiResponse
import retrofit2.http.DELETE
import retrofit2.http.Query

interface DeleteApi {
    /**
     * Deletes a cocktail
     *
     * @param cocktailId Cocktail id to delete
     * @return Call<ApiResponse>
    </ApiResponse> */
    @DELETE("delete.php")
    suspend fun deleteCocktail(
        @Query("cocktailId") cocktailId: String?
    ): ApiResponse
}