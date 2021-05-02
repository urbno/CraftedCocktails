package com.bme.aut.craftedcocktails.test

import com.bme.aut.craftedcocktails.mock.MockRandomApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainTest {

    private lateinit var mockRandomApi: MockRandomApi

    @Before
    fun initializeNetworkDataSource() {
        mockRandomApi = MockRandomApi()
    }

    /**
     * Search for a random cocktail
     * www.thecocktaildb.com/api/json/v1/1/random.php
     */
    @Test
    fun getRandomCocktailsTest() {
        runBlocking {
            val randomCocktail = mockRandomApi.getRandomCocktail()
            Assert.assertTrue(randomCocktail.drinks!!.isNotEmpty())
            Assert.assertEquals(1, randomCocktail.drinks!!.size)
            Assert.assertEquals("11007", randomCocktail.drinks!![0]?.idDrink)
        }
    }
}