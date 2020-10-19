package alex.ts.app.hw_11.repo

import alex.ts.app.hw_11.model.Currency
import alex.ts.app.hw_11.retrofit.Holder
import java.io.IOException

class Repository(private val holder: Holder) {

    suspend fun getPost(): List<Currency> {
        val list = mutableListOf<Currency>()
        val request = holder.getPostsAsync().await()
        try {
            list.addAll(request)
        } catch (e: IOException) {

        }
        return list
    }
}