package by.st.bankpro.landing.data.remote.impl

import by.st.bankpro.landing.data.local.SharedPreference
import by.st.bankpro.landing.data.network.models.UserJson
import by.st.bankpro.landing.data.network.fromJson
import by.st.bankpro.landing.data.network.toJson
import by.st.bankpro.landing.data.remote.ISharedPreferenceDataSource
import com.squareup.moshi.Moshi


class SharedPreferenceDataSource(
    private val sharedPreference: SharedPreference,
    val moshi: Moshi
) : ISharedPreferenceDataSource {

    override var user: UserJson?
        get() = TODO("Not yet implemented")
        set(value) {}
}