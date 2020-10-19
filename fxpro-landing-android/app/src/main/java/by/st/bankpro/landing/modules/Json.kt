package by.st.bankpro.landing.modules

import by.st.bankpro.landing.data.network.provideMoshi
import org.koin.dsl.module

val jsonModule = module {
    single { provideMoshi() }
}
