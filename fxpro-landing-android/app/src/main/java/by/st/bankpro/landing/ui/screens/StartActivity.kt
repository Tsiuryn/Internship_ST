package by.st.bankpro.landing.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.st.bankpro.landing.ui.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartActivity : AppCompatActivity() {

    private val viewModel: StartViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

}
