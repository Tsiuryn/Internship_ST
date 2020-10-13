package alex.ts.task_01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var change = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listenerButton()
        textFirst.setOnClickListener(this)
    }
    
    private fun changeText(){
        when (change) {
            true -> {
                textFirst.text = getString(R.string.second_text)
                textSecond.text = getString(R.string.first_text)
                textFirst.setBackgroundColor(ContextCompat.getColor(this, R.color.firstTextColor))
                textSecond.setBackgroundColor(ContextCompat.getColor(this, R.color.secondTextColor))
                change = false
            }
            false -> {
                textFirst.text = getString(R.string.first_text)
                textSecond.text = getString(R.string.second_text)
                textFirst.setBackgroundColor(ContextCompat.getColor(this, R.color.secondTextColor))
                textSecond.setBackgroundColor(ContextCompat.getColor(this, R.color.firstTextColor))
                change = true
            }
        }
    }

    private fun listenerButton() {
        btnChange.setOnClickListener {
          changeText()
        }
    }

    override fun onClick(view: View?) {
        if (view == textFirst){
            changeText()
        }
    }

    fun listenerTheSecondText(view: View?){
        changeText()
    }
}