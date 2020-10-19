package by.st.bankpro.landing.data.gateway.impl

import by.st.bankpro.landing.data.gateway.ICountryGateway
import by.st.bankpro.landing.data.remote.IReferencesDataSource
import by.st.bankpro.landing.domain.models.Country


class CountryGateway(
    private val referencesDataSource: IReferencesDataSource
): ICountryGateway {
    override suspend fun getCountries(): List<Country> {
        TODO("Not yet implemented")
    }
}