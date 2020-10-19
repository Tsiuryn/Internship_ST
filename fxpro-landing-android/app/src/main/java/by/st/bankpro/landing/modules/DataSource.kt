package by.st.bankpro.landing.modules

import by.st.bankpro.landing.data.remote.ISharedPreferenceDataSource
import by.st.bankpro.landing.data.remote.impl.ReferencesDataSource
import by.st.bankpro.landing.data.remote.impl.SharedPreferenceDataSource
import by.st.bankpro.landing.data.local.SharedPreference
import by.st.bankpro.landing.data.remote.IReferencesDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

val dataSourceModule: Module = module {
    single { SharedPreference() }
    single { ReferencesDataSource(httpApi = get()) as IReferencesDataSource }
    single { SharedPreferenceDataSource(sharedPreference = get(), moshi = get()) as ISharedPreferenceDataSource }
}