package bomond.cryptolist.ui.selectedElement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bomond.cryptolist.databinding.FragmentSelectedElementBinding

class SelectedElementFragment: Fragment() {

    private lateinit var binding: FragmentSelectedElementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSelectedElementBinding.inflate(inflater, container, false)

        return binding.root
    }

}