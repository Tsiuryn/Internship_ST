package alex.ts.app.hw_04.clock

import alex.ts.app.R
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_clock.*

class MyClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_clock)
        watchView.startClock()
        val animation = imgClockOwl.drawable as AnimationDrawable
        animation.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        overridePendingTransition(R.anim.set_left_in, R.anim.set_right_out)
    }
}