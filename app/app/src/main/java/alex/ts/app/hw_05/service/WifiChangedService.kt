package alex.ts.app.hw_05.service

import alex.ts.app.hw_05.const.SERVICE_FINISH
import alex.ts.app.hw_05.const.SERVICE_START
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class WifiChangedService : Service() {
    private val mBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {

        val myAction = intent.action
        when(myAction){
            SERVICE_START -> {
                Toast.makeText(this, myAction, Toast.LENGTH_SHORT).show()
            }
        }
        return mBinder
    }

    fun switchWifi(switchOn: Boolean) {
        val mWifi = this.getSystemService(Context.WIFI_SERVICE) as WifiManager
        mWifi.isWifiEnabled = switchOn
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, SERVICE_FINISH, Toast.LENGTH_SHORT).show()
    }

    inner class MyBinder : Binder() {
        fun getWifiChangedService(): WifiChangedService {
            return this@WifiChangedService
        }
    }
}
