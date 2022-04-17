package bomond.cryptolist.ui.home

import androidx.recyclerview.widget.RecyclerView
import bomond.cryptolist.R
import bomond.cryptolist.databinding.ViewElementHomeRecyclerBinding
import bomond.cryptolist.ui.base.list.FillAction
import bomond.cryptolist.util.loadImageFromUrl

class HomeElementViewHolder(
    var binding: ViewElementHomeRecyclerBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root), FillAction {

    override fun fill(item: Any?) {
        val element = viewModel.coinsList[bindingAdapterPosition]
        val context = binding.root.context
        with(binding) {
            image.loadImageFromUrl(element.image)
            name.text = element.name
            capitalization.text = element.capitalization
            price.text = element.price
            growth.text = element.growth
            growth.setTextColor(
            if (growth.text.substring(0, 1) == "-"){
                context.getColorStateList(bomond.cryptolist.resource.R.color.growthNegative)
            } else {
                context.getColorStateList(bomond.cryptolist.resource.R.color.growthPositive)
            })
        }
    }
}