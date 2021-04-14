package com.bme.aut.craftedcocktails.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class ApiResponse {
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("code")
    var code: Int? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("message")
    var message: String? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val apiResponse = o as ApiResponse
        return code == apiResponse.code &&
                message == apiResponse.message
    }

    override fun hashCode(): Int {
        return Objects.hash(code, message)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ApiResponse {\n")
        sb.append("    code: ").append(toIndentedString(code)).append("\n")
        sb.append("    message: ").append(toIndentedString(message)).append("\n")
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