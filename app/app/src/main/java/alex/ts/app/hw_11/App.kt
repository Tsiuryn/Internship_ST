package alex.ts.app.hw_11

import alex.ts.app.hw_11.di.appModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }
}