package by.st.bankpro.landing.modules

import by.st.bankpro.landing.ui.screens.StartViewModel
import by.st.bankpro.landing.ui.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel {
        StartViewModel(

        )
    }
    viewModel {
        MainViewModel(

        )
    }
}