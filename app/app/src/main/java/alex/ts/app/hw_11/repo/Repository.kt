package alex.ts.app.hw_11.repo

import alex.ts.app.hw_11.const.CURRENCY_URL
import alex.ts.app.hw_11.model.Currency
import alex.ts.app.hw_11.retrofit.Holder
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class Repository(private val context: Context) {
    private lateinit var holder: Holder

    private fun createRetrofit(){
        // HttpLoggingInterceptor - для отображения в логах URL
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(CURRENCY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
        holder = retrofit.create(Holder::class.java)
    }

    suspend fun getPost(): List<Currency> {
        createRetrofit()
        val list = mutableListOf<Currency>()
        val request = holder.getPostsAsync().await()
        try {
            list.addAll(request)
        } catch (e: IOException) {

        }
        return list
    }
}