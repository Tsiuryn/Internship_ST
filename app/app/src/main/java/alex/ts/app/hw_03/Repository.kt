package alex.ts.app.hw_03

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class Repository(private val context: Context, private val progressBar: ProgressBar, private val imageView: ImageView): Callback  {
    fun download(url: String){
        Picasso.get().load(url)
            .transform(CircularTransformation(context, 250))
            .into(imageView, this)
    }

    override fun onSuccess() {
        progressBar.visibility = View.GONE
    }

    override fun onError(e: Exception?) {
    }
}