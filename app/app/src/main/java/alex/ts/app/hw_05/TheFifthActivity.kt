package alex.ts.app.hw_05

import alex.ts.app.R
import alex.ts.app.hw_05.const.SERVICE_START
import alex.ts.app.hw_05.const.WIFI_TURN_OFF
import alex.ts.app.hw_05.const.WIFI_TURN_ON
import alex.ts.app.hw_05.service.WifiChangedService
import android.content.*
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_the_fifth.*

class TheFifthActivity : AppCompatActivity() {
    private var isWifiOn = false
    private var bound = true
    private lateinit var sCon: ServiceConnection

    private val myBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            getCurrentStateOfWiFi()
        }
    }

    private fun registerMyReceiver (){
        val filters = IntentFilter()
        filters.addAction("android.net.wifi.WIFI_STATE_CHANGED")
        filters.addAction("android.net.wifi.STATE_CHANGE")
        registerReceiver(myBroadcastReceiver, filters)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_fifth)
        getCurrentStateOfWiFi()
        listenerWifiStateButton()
        bindService(SERVICE_START)

    }

    private fun bindService(action : String){
        sCon = object : ServiceConnection{
            override fun onServiceDisconnected(p0: ComponentName?) {
                bound = false
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                bound = true
            }

        }
        val intent = Intent(this, WifiChangedService::class.java)
        intent.action = action
        bindService(intent, sCon, Context.BIND_AUTO_CREATE)
    }

    override fun onResume() {
        super.onResume()
        registerMyReceiver()
    }

    private fun listenerWifiStateButton() {
        btnChangeStateWifi.setOnClickListener{
            if (isWifiOn){
                bindService(WIFI_TURN_OFF)
            }else{
                bindService(WIFI_TURN_ON)
            }
        }
    }

    private fun getCurrentStateOfWiFi(){
        val wifiMgr = applicationContext
            .getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (wifiMgr.isWifiEnabled){
            tvWiFi.text = getString(R.string.wifi_is_on)
            isWifiOn = true
        }else{
            tvWiFi.text = getString(R.string.wifi_is_of)
            isWifiOn = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
        if (bound){
             unbindService(sCon)
            bound = false
        }
    }
}