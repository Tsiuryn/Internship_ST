package alex.ts.app.hw_04

import alex.ts.app.R
import alex.ts.app.hw_04.clock.MyClockActivity
import alex.ts.app.hw_04.diagram.MyDiagramActivity
import alex.ts.app.hw_04.owl_animation.OwlAnimationActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_the_fourth.*

class TheFourthActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_fourth)
        btnOwlAnim.setOnClickListener(this)
        btnClock.setOnClickListener(this)
        btnDiagram.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnOwlAnim ->{
                startActivityForResult(Intent(this, OwlAnimationActivity::class.java), 1)
                overridePendingTransition(R.anim.set_right_in, R.anim.set_left_out)
            }
            btnClock ->{
                startActivityForResult(Intent(this, MyClockActivity::class.java), 1)
                overridePendingTransition(R.anim.set_right_in, R.anim.set_left_out)
            }
            btnDiagram ->{
                startActivityForResult(Intent(this, MyDiagramActivity::class.java), 1)
                overridePendingTransition(R.anim.set_right_in, R.anim.set_left_out)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        overridePendingTransition(R.anim.set_right_in, R.anim.set_left_out)
    }
}