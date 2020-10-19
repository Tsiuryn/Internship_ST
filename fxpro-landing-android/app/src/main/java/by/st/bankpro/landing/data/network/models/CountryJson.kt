package by.st.bankpro.landing.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryJson(
   @field: Json(name = "name") val name: String
)