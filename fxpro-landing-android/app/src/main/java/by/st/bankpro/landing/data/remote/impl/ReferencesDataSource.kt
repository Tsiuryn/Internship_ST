package by.st.bankpro.landing.data.remote.impl

import by.st.bankpro.landing.data.network.models.CountryJson
import by.st.bankpro.landing.data.network.RestApi
import by.st.bankpro.landing.data.remote.IReferencesDataSource


class ReferencesDataSource(
    private val httpApi: RestApi
) : IReferencesDataSource {

    override suspend fun getCountries(): List<CountryJson> {
        return TODO()  //httpApi.getCountries()
    }
}