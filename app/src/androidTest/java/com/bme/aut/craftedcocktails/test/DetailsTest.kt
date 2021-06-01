package com.bme.aut.craftedcocktails.test

import com.bme.aut.craftedcocktails.mock.MockLookupApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailsTest {

    private lateinit var mockLookupApi: MockLookupApi

    @Before
    fun initializeNetworkDataSource() {
        mockLookupApi = MockLookupApi()
    }

    /**
     * Lookup full cocktail details by id
     * www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
     */
    @Test
    fun getCocktailDetailsByIdTest() {
        runBlocking {
            val detailedCocktail = mockLookupApi.getCocktailById("11007")
            Assert.assertTrue(detailedCocktail.drinks!!.isNotEmpty())
            Assert.assertEquals(1, detailedCocktail.drinks!!.size)
            Assert.assertEquals("11007", detailedCocktail.drinks!![0]?.idDrink)
        }
    }
}