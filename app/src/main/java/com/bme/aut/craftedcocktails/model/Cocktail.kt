package com.bme.aut.craftedcocktails.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class Cocktail {
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("idDrink")
    var idDrink: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strDrink")
    var strDrink: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strCategory")
    var strCategory: String? = null

    enum class StrAlcoholicEnum(private val value: String) {
        ALCOHOLIC("Alcoholic"), NON_ALCOHOLIC("Non alcoholic");

        override fun toString(): String {
            return value
        }
    }

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strAlcoholic")
    var strAlcoholic: StrAlcoholicEnum? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strGlass")
    var strGlass: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strInstructions")
    var strInstructions: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strDrinkThumb")
    var strDrinkThumb: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strIngredient1")
    var strIngredient1: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strIngredient2")
    var strIngredient2: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strIngredient3")
    var strIngredient3: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strIngredient4")
    var strIngredient4: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strIngredient5")
    var strIngredient5: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strMeasure1")
    var strMeasure1: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strMeasure2")
    var strMeasure2: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strMeasure3")
    var strMeasure3: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strMeasure4")
    var strMeasure4: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("strMeasure5")
    var strMeasure5: String? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val cocktail = o as Cocktail
        return idDrink == cocktail.idDrink &&
                strDrink == cocktail.strDrink &&
                strCategory == cocktail.strCategory &&
                strAlcoholic == cocktail.strAlcoholic &&
                strGlass == cocktail.strGlass &&
                strInstructions == cocktail.strInstructions &&
                strDrinkThumb == cocktail.strDrinkThumb &&
                strIngredient1 == cocktail.strIngredient1 &&
                strIngredient2 == cocktail.strIngredient2 &&
                strIngredient3 == cocktail.strIngredient3 &&
                strIngredient4 == cocktail.strIngredient4 &&
                strIngredient5 == cocktail.strIngredient5 &&
                strMeasure1 == cocktail.strMeasure1 &&
                strMeasure2 == cocktail.strMeasure2 &&
                strMeasure3 == cocktail.strMeasure3 &&
                strMeasure4 == cocktail.strMeasure4 &&
                strMeasure5 == cocktail.strMeasure5
    }

    override fun hashCode(): Int {
        return Objects.hash(
            idDrink,
            strDrink,
            strCategory,
            strAlcoholic,
            strGlass,
            strInstructions,
            strDrinkThumb,
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strMeasure1,
            strMeasure2,
            strMeasure3,
            strMeasure4,
            strMeasure5
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Cocktail {\n")
        sb.append("    idDrink: ").append(toIndentedString(idDrink)).append("\n")
        sb.append("    strDrink: ").append(toIndentedString(strDrink)).append("\n")
        sb.append("    strCategory: ").append(toIndentedString(strCategory)).append("\n")
        sb.append("    strAlcoholic: ").append(toIndentedString(strAlcoholic)).append("\n")
        sb.append("    strGlass: ").append(toIndentedString(strGlass)).append("\n")
        sb.append("    strInstructions: ").append(toIndentedString(strInstructions)).append("\n")
        sb.append("    strDrinkThumb: ").append(toIndentedString(strDrinkThumb)).append("\n")
        sb.append("    strIngredient1: ").append(toIndentedString(strIngredient1)).append("\n")
        sb.append("    strIngredient2: ").append(toIndentedString(strIngredient2)).append("\n")
        sb.append("    strIngredient3: ").append(toIndentedString(strIngredient3)).append("\n")
        sb.append("    strIngredient4: ").append(toIndentedString(strIngredient4)).append("\n")
        sb.append("    strIngredient5: ").append(toIndentedString(strIngredient5)).append("\n")
        sb.append("    strMeasure1: ").append(toIndentedString(strMeasure1)).append("\n")
        sb.append("    strMeasure2: ").append(toIndentedString(strMeasure2)).append("\n")
        sb.append("    strMeasure3: ").append(toIndentedString(strMeasure3)).append("\n")
        sb.append("    strMeasure4: ").append(toIndentedString(strMeasure4)).append("\n")
        sb.append("    strMeasure5: ").append(toIndentedString(strMeasure5)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}