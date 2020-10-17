package alex.ts.app.hw_08.task_2

import alex.ts.app.R
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    private var numb = 0
    private lateinit var handler: Handler
    private lateinit var mRunnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        val looper = Looper.getMainLooper()
        handler = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Handler.createAsync(looper)
        } else {
            Handler()
        }
        Toast.makeText(this, "The Toast will be shown every 7 seconds!", Toast.LENGTH_LONG).show()
        startTimer()
    }

    private fun startTimer() {
        mRunnable = Runnable {
            if (hw8SwitchTimerActivity.isChecked) {
                if (numb % 2 == 0) {
                    hw8TimerActivity.text = numb.toString()
                }
            } else {
                hw8TimerActivity.text = numb.toString()
            }

            if (numb % 7 == 0 && numb != 0) {
                Toast.makeText(this, "$numb seconds has passed", Toast.LENGTH_SHORT).show()
            }

            numb++
            handler.postDelayed(
                mRunnable,
                1000
            )
        }
        handler.postDelayed(
            mRunnable,
            1000
        )
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(mRunnable)
    }
}