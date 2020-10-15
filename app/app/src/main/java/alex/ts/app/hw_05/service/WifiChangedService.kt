package alex.ts.app.hw_05.service

import alex.ts.app.hw_05.const.SERVICE_FINISH
import alex.ts.app.hw_05.const.SERVICE_START
import alex.ts.app.hw_05.const.WIFI_TURN_OFF
import alex.ts.app.hw_05.const.WIFI_TURN_ON
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class WifiChangedService : Service() {

    override fun onBind(intent: Intent): IBinder {
        val myAction = intent.action
        when(myAction){
            WIFI_TURN_OFF->{
                switchWifi(false)
            }
            WIFI_TURN_ON ->{
                switchWifi(true)
            }
            SERVICE_START ->{
                Toast.makeText(this, myAction, Toast.LENGTH_SHORT).show()

            }
        }
        return Binder()
    }

    private fun switchWifi(switchOn: Boolean){
        val mWifi = this.getSystemService(Context.WIFI_SERVICE) as WifiManager
        mWifi.isWifiEnabled = switchOn
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, SERVICE_FINISH, Toast.LENGTH_SHORT).show()
    }
}
