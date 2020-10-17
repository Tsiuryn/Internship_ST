package alex.ts.app

import alex.ts.app.hw_01.TheFirstActivity
import alex.ts.app.hw_02.TheSecondActivity
import alex.ts.app.hw_03.TheThirdActivity
import alex.ts.app.hw_04.TheFourthActivity
import alex.ts.app.hw_04.const.REQUEST_START_ACTIVITY
import alex.ts.app.hw_05.TheFifthActivity
import alex.ts.app.hw_06.TheSixthActivity
import alex.ts.app.hw_07.TheSeventhActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainHW1.setOnClickListener(this)
        mainHW2.setOnClickListener(this)
        mainHW3.setOnClickListener(this)
        mainHW4.setOnClickListener(this)
        mainHW5.setOnClickListener(this)
        mainHW6.setOnClickListener(this)
        mainHW7.setOnClickListener(this)
        mainHW8.setOnClickListener(this)
        mainHW9.setOnClickListener(this)
        mainHW10.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            mainHW1 -> startActivity(Intent(this, TheFirstActivity::class.java))

            mainHW2 -> startActivity(Intent(this, TheSecondActivity::class.java))

            mainHW3 -> startActivity(Intent(this, TheThirdActivity::class.java))

            mainHW4 -> {
                startActivityForResult(
                    Intent(this, TheFourthActivity::class.java),
                    REQUEST_START_ACTIVITY
                )
                overridePendingTransition(R.anim.set_left_in, R.anim.set_right_out)
            }
            mainHW5 -> startActivity(Intent(this, TheFifthActivity::class.java))

            mainHW6 -> startActivity(Intent(this, TheSixthActivity::class.java))

            mainHW7 -> startActivity(Intent(this, TheSeventhActivity::class.java))

        }
    }


}