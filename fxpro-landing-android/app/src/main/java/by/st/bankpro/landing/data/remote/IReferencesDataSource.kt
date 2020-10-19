package by.st.bankpro.landing.data.remote

import by.st.bankpro.landing.data.network.models.CountryJson

interface IReferencesDataSource {
    suspend fun getCountries(): List<CountryJson>
}