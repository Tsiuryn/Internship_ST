package by.st.bankpro.landing.data.remote

import by.st.bankpro.landing.data.network.models.UserJson

interface ISharedPreferenceDataSource {
    var user: UserJson?
}