package alex.ts.app

import alex.ts.app.hw_01.TheFirstActivity
import alex.ts.app.hw_02.TheSecondActivity
import android.content.Context
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
    }

    override fun onClick(view: View?) {
        when (view) {
            mainHW1 ->{
                val intent = Intent(this, TheFirstActivity::class.java)
                startActivity(intent)
            }
            mainHW2 ->{
                val intent = Intent(this, TheSecondActivity::class.java)
                startActivity(intent)
            }
        }
    }


}