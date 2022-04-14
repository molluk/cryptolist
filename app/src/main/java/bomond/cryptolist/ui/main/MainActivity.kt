package bomond.cryptolist.ui.main

import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import bomond.cryptolist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.activity_main) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        currentFocus?.let { currFocus ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currFocus.windowToken, 0)
            if (currentFocus != null) {
                currentFocus!!.clearFocus()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

}