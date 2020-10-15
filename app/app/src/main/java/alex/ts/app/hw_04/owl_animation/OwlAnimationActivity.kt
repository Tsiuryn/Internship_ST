package alex.ts.app.hw_04.owl_animation

import alex.ts.app.R
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_owl_animation.*

class OwlAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owl_animation)
        val animation = imgOwl.drawable as AnimationDrawable
        animation.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        overridePendingTransition(R.anim.set_left_in, R.anim.set_right_out)
    }
}