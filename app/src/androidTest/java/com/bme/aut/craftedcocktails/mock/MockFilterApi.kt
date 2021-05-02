package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.model.Drinks
import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.FilterApi
import kotlinx.coroutines.delay

class MockFilterApi : FilterApi {

    /**
     * @param a alcoholic
     * www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
     * www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic
     *
     * @param i ingredient
     * www.thecocktaildb.com/api/json/v1/1/filter.php?i=Gin
     */
    override suspend fun searchCocktailByFilter(a: String?, i: String?): Response {
        delay(1000)
        if (!a.isNullOrEmpty()) {
            if (a == "Alcoholic") {
                return Response().also { response ->
                    response.drinks = Drinks().also { drinks ->
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "1-900-FUK-MEUP"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/uxywyw1468877224.jpg"
                            cocktail.idDrink = "15395"
                        })
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "110 in the shade"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg"
                            cocktail.idDrink = "15423"
                        })
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "151 Florida Bushwacker"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/rvwrvv1468877323.jpg"
                            cocktail.idDrink = "14588"
                        })
                    }
                }
            } else if (a == "Non_Alcoholic") {
                return Response().also { response ->
                    response.drinks = Drinks().also { drinks ->
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "Afterglow"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/vuquyv1468876052.jpg"
                            cocktail.idDrink = "12560"
                        })
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "Alice Cocktail"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/qyqtpv1468876144.jpg"
                            cocktail.idDrink = "12562"
                        })
                        drinks.add(Cocktail().also { cocktail ->
                            cocktail.strDrink = "Aloha Fruit punch"
                            cocktail.strDrinkThumb =
                                "https://www.thecocktaildb.com/images/media/drink/wsyvrt1468876267.jpg"
                            cocktail.idDrink = "12862"
                        })
                    }
                }
            }
        }
        if (!i.isNullOrEmpty()) {
            return Response().also { response ->
                response.drinks = Drinks().also { drinks ->
                    drinks.add(Cocktail().also { cocktail ->
                        cocktail.strDrink = "3-Mile Long Island Iced Tea"
                        cocktail.strDrinkThumb =
                            "https://www.thecocktaildb.com/images/media/drink/rrtssw1472668972.jpg"
                        cocktail.idDrink = "15300"
                    })
                    drinks.add(Cocktail().also { cocktail ->
                        cocktail.strDrink = "69 Special"
                        cocktail.strDrinkThumb =
                            "https://www.thecocktaildb.com/images/media/drink/vqyxqx1472669095.jpg"
                        cocktail.idDrink = "13940"
                    })
                    drinks.add(Cocktail().also { cocktail ->
                        cocktail.strDrink = "Abbey Cocktail"
                        cocktail.strDrinkThumb =
                            "https://www.thecocktaildb.com/images/media/drink/mr30ob1582479875.jpg"
                        cocktail.idDrink = "17834"
                    })
                }
            }
        }
        return Response()
    }
}