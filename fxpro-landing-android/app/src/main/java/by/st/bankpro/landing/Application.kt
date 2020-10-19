package by.st.bankpro.landing

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import by.st.bankpro.landing.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        setUpNightMode()
        setUpVectorCompat()
        setUpKoin()
        setUpLog()
    }

    private fun setUpNightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun setUpVectorCompat() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    networkModule,
                    jsonModule,
                    gatewayModule,
                    dataSourceModule
                )
            )
        }
    }

    private fun setUpLog() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}