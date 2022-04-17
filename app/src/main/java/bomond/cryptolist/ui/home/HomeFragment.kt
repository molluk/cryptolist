package bomond.cryptolist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import bomond.cryptolist.R
import bomond.cryptolist.databinding.FragmentHomeBinding
import bomond.cryptolist.ui.base.list.BaseListItem
import bomond.cryptolist.di.data.HomeData
import bomond.cryptolist.util.CustomDividerItemDecoration
import bomond.cryptolist.views.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
//        binding.setVariable(BR.viewModel, viewModel)

        initToolbar()
        initRecyclerView()

        return binding.root
    }

    private fun initToolbar() {
        //TODO("Not yet implemented")
    }

    private fun initRecyclerView() {
        adapter = HomeAdapter(viewModel)
        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(
            CustomDividerItemDecoration(
                requireContext(),
                RecyclerView.VERTICAL
            ).get8dp(true)
        )
        for (element in 0..30) {
            val sign = if (element % 2 == 0){
                "+"
            } else {
                "-"
            }
            viewModel.coinsList.add(
                HomeData.Element(
                    "https://www.dhresource.com/0x0/f2/albu/g9/M00/27/85/rBVaVVxO822ACwv4AALYau1h4a8355.jpg",
                    "Bitcoin",
                    "₽${943 + element} 514,42M",
                    "₽${3 + element},369,789.72",
                    "$sign${110 + element},08%"
                )
            )
        }
        for (element in viewModel.coinsList.withIndex()) {
            adapter.addItem(
                BaseListItem(
                    viewModel.coinsList[element.index]
                )
            )
        }
    }
}