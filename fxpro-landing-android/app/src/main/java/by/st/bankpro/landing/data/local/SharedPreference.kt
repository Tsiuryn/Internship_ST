package by.st.bankpro.landing.data.local

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import by.st.bankpro.landing.Application

class SharedPreference {

    private val PREFERENCES: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(Application.instance)



}