package alex.ts.app.hw_09.viewmodel

import alex.ts.app.R
import alex.ts.app.hw_09.model.User
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

class TheNinthViewModel : ViewModel() {
    companion object{
        @JvmStatic
        @BindingAdapter("my_src")
        fun getPhoto(imageView: ImageView, url: String) {
            val context = imageView.context
            Glide.with(context).load(url).into(imageView)
        }

        @JvmStatic
        @BindingAdapter("text_color")
        fun setColor (textView: TextView, sex: String){
            if (sex == "man"){
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.manColor))
            }
            else {
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.womanColor))

            }
        }
    }

    private val user = User(
        "Nikita",
        "Puhov",
        "28",
        "man"
    )

    val myUrl: String
        get() = user.myUrl

    val myName: String
        get() = "Name: " + user.name

    val surname: String
        get() = "Surname: " + user.surname

    val age: String
        get() = "Age: " + user.age

    val gender: String
        get() = "Gender: " + user.gender
}