package com.bme.aut.craftedcocktails.model

import io.swagger.annotations.ApiModel
import java.util.*

@ApiModel(description = "")
class Drinks : ArrayList<Cocktail?>() {
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val drinks = o as Drinks
        return true
    }

    override fun hashCode(): Int {
        return Objects.hash()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Drinks {\n")
        sb.append("    ").append(toIndentedString(super.toString())).append("\n")
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