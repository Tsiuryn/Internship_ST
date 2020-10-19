package by.st.bankpro.landing.data.network

import com.squareup.moshi.Moshi


fun provideMoshi(): Moshi =
    Moshi.Builder().apply {

    }.build()


inline fun <reified T> Moshi.fromJson(json: String): T? =
    adapter(T::class.java).fromJson(json)

inline fun <reified T> Moshi.toJson(any: T): String =
    adapter(T::class.java).toJson(any)