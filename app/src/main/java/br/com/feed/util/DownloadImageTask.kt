package br.com.feed.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

/**
 * Created by willans on 02/02/19.
 */
class DownloadImageTask(val imageView: ImageView): AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg params: String?): Bitmap {
        val url = params[0]

        val strem = URL(url).openStream()
        val bitmap = BitmapFactory.decodeStream(strem)

        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        imageView.setImageBitmap(result)
    }

}