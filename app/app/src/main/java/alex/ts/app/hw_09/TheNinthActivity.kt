package alex.ts.app.hw_09

import alex.ts.app.R
import alex.ts.app.databinding.ActivityTheNinthBinding
import alex.ts.app.hw_09.viewmodel.TheNinthViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class TheNinthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = ViewModelProvider(this).get(TheNinthViewModel::class.java)
        DataBindingUtil.setContentView<ActivityTheNinthBinding>(this, R.layout.activity_the_ninth)
            .apply {
                this.lifecycleOwner = this@TheNinthActivity
                this.viewModel = vm
            }
    }
}