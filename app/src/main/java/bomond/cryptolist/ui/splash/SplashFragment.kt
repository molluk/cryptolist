package bomond.cryptolist.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import bomond.cryptolist.R
import bomond.cryptolist.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        val navController =
            Navigation.findNavController(requireActivity(), R.id.activityFragmentHost)

        val mainGraph = navController.navInflater.inflate(R.navigation.start_navigation_graph)

        return binding.root
    }
}