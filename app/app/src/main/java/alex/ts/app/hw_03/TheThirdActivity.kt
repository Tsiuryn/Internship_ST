package alex.ts.app.hw_03

import alex.ts.app.BuildConfig
import alex.ts.app.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_the_third.*

class TheThirdActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_third)
        btnShowToast.setOnClickListener(this)
        btnDownload.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnShowToast ->{
                val text = BuildConfig.API_ENDPOINT
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
            btnDownload ->{
                progressBar.visibility = View.VISIBLE
                val url = myUrl.text.toString()
                downloadImage(url)
            }
        }
    }

    private fun downloadImage(url: String){
        runOnUiThread {
            Repository(this, progressBar, imgFromNet).download(url)
        }
    }
}