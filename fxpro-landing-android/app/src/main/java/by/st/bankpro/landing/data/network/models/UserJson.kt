package by.st.bankpro.landing.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserJson(
    @field: Json(name = "firstName") val firstName: String,
    @field: Json(name = "lastName") val lastName: String,
    @field: Json(name = "email") val email: String,
    @field: Json(name = "password") val password: String
)