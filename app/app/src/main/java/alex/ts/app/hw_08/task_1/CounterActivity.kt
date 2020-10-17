package alex.ts.app.hw_08.task_1

import alex.ts.app.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        val vm = ViewModelProvider(this).get(MyCounterViewModel::class.java)
        hw8TvActivity.text = "0"
        hw8BtnPlus.setOnClickListener{
            val numb = hw8TvActivity.text.toString().toInt()
            vm.sendNumberToFragment(numb+1)
            hw8TvActivity.text = (numb +1).toString()
        }
    }
}