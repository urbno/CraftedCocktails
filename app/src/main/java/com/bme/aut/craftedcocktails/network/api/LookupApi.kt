package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Response
import retrofit2.Call
import retrofit2.http.*

interface LookupApi {
    /**
     * Lookup full cocktail details by id
     * Returns a single cocktail
     * @param i ID of cocktail to return
     * @return Call<Response>
    </Response> */
    @GET("lookup.php")
    fun getCocktailById(
        @Query("i") i: Long?
    ): Call<Response?>?

    /**
     * Updates a cocktail in the database with form data
     *
     * @param cocktailId ID of cocktail that needs to be updated
     * @param name Updated name of the cocktail
     * @param status Updated status of the cocktail
     * @return Call<Void>
    </Void> */
    @FormUrlEncoded
    @POST("lookup.php")
    fun updateCocktailWithForm(
        @Query("cocktailId") cocktailId: Long?,
        @Field("name") name: String?,
        @Field("status") status: String?
    ): Call<Void?>?
}