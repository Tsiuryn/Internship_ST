package by.st.bankpro.landing.modules

import by.st.bankpro.landing.data.gateway.ICountryGateway
import by.st.bankpro.landing.data.gateway.impl.CountryGateway
import org.koin.core.module.Module
import org.koin.dsl.module

val gatewayModule: Module = module {
    single {
        CountryGateway(
            referencesDataSource = get()
        ) as ICountryGateway
    }
}