package alex.ts.app.hw_11.retrofit

import alex.ts.app.hw_11.model.Currency
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Holder {

    @GET("rates?periodicity=0")
    fun getPostsAsync() : Deferred<List<Currency>>
}