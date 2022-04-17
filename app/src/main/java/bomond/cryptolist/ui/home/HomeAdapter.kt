package bomond.cryptolist.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import bomond.cryptolist.R
import bomond.cryptolist.databinding.ViewElementHomeRecyclerBinding
import bomond.cryptolist.ui.base.list.BaseListItem
import bomond.cryptolist.ui.base.list.FillAction
import bomond.cryptolist.util.assistant.dp

class HomeAdapter(val viewModel: HomeViewModel) : bomond.cryptolist.ui.base.BaseAdapter<BaseListItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewElementHomeRecyclerBinding = DataBindingUtil.inflate(
            inflater, R.layout.view_element_home_recycler,
            parent,
            false
        )
        return HomeElementViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FillAction) {
            holder.itemView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                setMargins(0, 8.dp, 0, 8.dp)
            }
            holder.fill(data[position].data)
        }
    }
}