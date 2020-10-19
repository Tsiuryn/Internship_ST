package by.st.bankpro.landing.modules

import by.st.bankpro.landing.domain.usecase.*
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    factory { GetCountries(countryGateway = get()) }
}