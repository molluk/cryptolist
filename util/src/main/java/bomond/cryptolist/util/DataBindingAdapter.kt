package bomond.cryptolist.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import bomond.cryptolist.util.assistant.dp
import coil.load

@BindingAdapter("loadImage", requireAll = false)
fun ImageView.loadImageFromUrl(url: String) {
    if (!url.isNullOrEmpty()) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 4.dp.toFloat()
        circularProgressDrawable.centerRadius = 20.dp.toFloat()
        circularProgressDrawable.start()
        this.load(url)
        {
            crossfade(true)
            //загрузка
            placeholder(circularProgressDrawable)
            //ошибка
            error(circularProgressDrawable)
        }
    }
}