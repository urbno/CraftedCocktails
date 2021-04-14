package com.bme.aut.craftedcocktails.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class Response {
    /**
     *
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("drinks")
    var drinks: Drinks? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val response = o as Response
        return drinks == response.drinks
    }

    override fun hashCode(): Int {
        return Objects.hash(drinks)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Response {\n")
        sb.append("    drinks: ").append(toIndentedString(drinks)).append("\n")
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