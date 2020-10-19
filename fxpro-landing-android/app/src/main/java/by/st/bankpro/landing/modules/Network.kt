package by.st.bankpro.landing.modules

import by.st.bankpro.landing.API_URL
import by.st.bankpro.landing.data.network.provideOkHttpClient
import by.st.bankpro.landing.data.network.provideRestApi
import org.koin.dsl.module

val networkModule = module {

    single {
        provideOkHttpClient()
    }

    single {
        provideRestApi(
            baseUrl = API_URL,
            moshi = get(),
            okHttpClient = get()
        )
    }

}