package alex.ts.app.hw_11.di

import alex.ts.app.hw_11.const.CURRENCY_URL
import alex.ts.app.hw_11.repo.Repository
import alex.ts.app.hw_11.retrofit.Holder
import androidx.annotation.experimental.UseExperimental
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { createRetrofit(CURRENCY_URL) }
}

fun createRetrofit(url: String): Holder{
    // HttpLoggingInterceptor - для отображения в логах URL
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BASIC
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client)
        .build().create(Holder::class.java)

}