package by.st.bankpro.landing.domain.usecase

import by.st.bankpro.landing.data.gateway.ICountryGateway
import by.st.bankpro.landing.domain.models.Country


class GetCountries(
    private val countryGateway: ICountryGateway
) {
    suspend operator fun invoke(): List<Country> {
        TODO()
    }
}