package by.st.bankpro.landing.data.network

import android.util.Log
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        readTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        addInterceptor(getLoggingInterceptor())
    }.build()
}

fun provideRestApi(
    baseUrl: String,
    moshi: Moshi,
    okHttpClient: OkHttpClient
): RestApi {
    val retrofit = Retrofit.Builder().apply {
        addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        client(okHttpClient)
        baseUrl(baseUrl)
    }.build()

    return retrofit.create()
}

fun getLoggingInterceptor(): Interceptor {
    return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.w("OkHttp", message)
        }
    }).apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}