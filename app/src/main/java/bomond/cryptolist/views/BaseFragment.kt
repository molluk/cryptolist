package bomond.cryptolist.views

import android.content.res.Resources
import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import bomond.cryptolist.ui.main.MainActivity
import com.google.android.material.appbar.MaterialToolbar

open class BaseFragment : Fragment() {

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels

    fun Fragment.getMainActivity(): MainActivity {
        return requireActivity() as MainActivity
    }

    fun Fragment.getAppCompatActivity(): AppCompatActivity {
        return requireActivity() as AppCompatActivity
    }

    fun FragmentActivity.findFragmentContainerNavController(@IdRes host: Int): NavController {
        try {
            val navHostFragment = supportFragmentManager.findFragmentById(host) as NavHostFragment
            return navHostFragment.findNavController()
        } catch (e: Exception) {
            throw IllegalStateException("Activity $this does not have a NavController set on $host")
        }
    }


    fun setToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
    }

    fun Fragment.addOnBackPressedCallback(
        enabled: Boolean = true,
        onBackPressed: OnBackPressedCallback.() -> Unit
    ): OnBackPressedCallback {
        return object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() = onBackPressed()
        }.also { requireActivity().onBackPressedDispatcher.addCallback(this, it) }
    }

}