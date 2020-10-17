package alex.ts.app.hw_08

import alex.ts.app.R
import alex.ts.app.hw_08.task_1.CounterActivity
import alex.ts.app.hw_08.task_2.TimerActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_the_eighth.*

class TheEighthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_eighth)
        hw8BtnActivityTask1.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CounterActivity::class.java
                )
            )
        }
        hw8BtnActivityTask2.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    TimerActivity::class.java
                )
            )
        }
    }
}