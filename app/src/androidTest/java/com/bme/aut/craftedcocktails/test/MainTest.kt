package com.bme.aut.craftedcocktails.test

import com.bme.aut.craftedcocktails.mock.MockFilterApi
import com.bme.aut.craftedcocktails.mock.MockLookupApi
import com.bme.aut.craftedcocktails.mock.MockRandomApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainTest {

    private lateinit var mockRandomApi: MockRandomApi
    private lateinit var mockLookupApi: MockLookupApi
    private lateinit var mockFilterApi: MockFilterApi

    @Before
    fun initializeNetworkDataSource() {
        mockRandomApi = MockRandomApi()
        mockLookupApi = MockLookupApi()
        mockFilterApi = MockFilterApi()
    }

    /**
     * Search for a random cocktail
     * www.thecocktaildb.com/api/json/v1/1/random.php
     */
    @Test
    fun getRandomCocktailsTest() {
        runBlocking {
            val randomCocktail = mockRandomApi.getRandomCocktail()
            assertTrue(randomCocktail.drinks!!.isNotEmpty())
            assertEquals(1, randomCocktail.drinks!!.size)
            assertEquals("11007", randomCocktail.drinks!![0]?.idDrink)
        }
    }

    /**
     * Filter by alcoholic
     * www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
     */
    @Test
    fun getAlcoholicCocktailsTest() {
        runBlocking {
            val alcoholicCocktails = mockFilterApi.searchCocktailByFilter("Alcoholic", null)
            assertEquals(3, alcoholicCocktails.drinks?.size)
        }
    }

    /**
     * Filter by non alcoholic
     * www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic
     */
    @Test
    fun getNonAlcoholicCocktailsTest() {
        runBlocking {
            val nonAlcoholicCocktails = mockFilterApi.searchCocktailByFilter("Non_Alcoholic", null)
            assertEquals(3, nonAlcoholicCocktails.drinks?.size)
        }
    }

    /**
     * Search by ingredient
     * www.thecocktaildb.com/api/json/v1/1/filter.php?i=Gin
     */
    @Test
    fun geCocktailByIngredientTest() {
        runBlocking {
            val ginnedCocktails = mockFilterApi.searchCocktailByFilter(null, "Gin")
            assertEquals(3, ginnedCocktails.drinks?.size)
        }
    }
}