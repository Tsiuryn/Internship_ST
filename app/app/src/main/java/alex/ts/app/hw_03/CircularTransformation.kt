package alex.ts.app.hw_03

import alex.ts.app.R
import android.content.Context
import android.graphics.*
import androidx.core.content.ContextCompat
import com.squareup.picasso.Transformation

class CircularTransformation (private val context: Context, private val mRadius: Int): Transformation {
    override fun key(): String {
        return "square"
    }

    override fun transform(source: Bitmap?): Bitmap {
        val output = Bitmap.createBitmap(source!!.width, source.height,
        Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val paint = Paint()
        val rect = Rect (0, 0, source.width, source.height)
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true

        canvas.drawARGB(0,0,0,0)
        paint.color = ContextCompat.getColor(context, R.color.picassoColor)

        if (mRadius == 0) {
            canvas.drawCircle(source.getWidth() / 2 + 0.7f, source.getHeight() / 2 + 0.7f,
                source.getWidth() / 2 - 1.1f, paint)
        } else {
            canvas.drawCircle(source.getWidth() / 2 + 0.7f, source.getHeight() / 2 + 0.7f,
                mRadius.toFloat(), paint)
        }

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        canvas.drawBitmap(source, rect, rect, paint);
        if (source != output) {
            source.recycle()
        }
        return output
    }
}