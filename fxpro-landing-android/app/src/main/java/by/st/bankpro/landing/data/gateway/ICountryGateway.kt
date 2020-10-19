package by.st.bankpro.landing.data.gateway

import by.st.bankpro.landing.domain.models.Country

interface ICountryGateway {
    suspend fun getCountries(): List<Country>
}