package bomond.cryptolist.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bomond.cryptolist.ui.base.list.BaseListItem
import bomond.cryptolist.ui.base.list.BaseVH
import bomond.cryptolist.ui.base.list.FillAction

open class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() where T : BaseListItem {

    var data: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FillAction) {
            holder.fill(data[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(android.R.layout.test_list_item, parent, false)
        return BaseVH(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].viewType
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun stockData(list: List<T>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    fun addData(list: MutableList<T>) {
        val oldSize = itemCount
        data.addAll(list)
        notifyItemRangeInserted(oldSize, itemCount)
    }

    fun addItem(item: T) {
        data.add(item)
        notifyItemInserted(data.lastIndex)
    }

    fun addItemTo(item: T, index: Int) {
        if (data.size == index || data.size > index && data[index] != item) {
            data.add(index, item)
            notifyItemInserted(index)
        }
    }

    fun addItemInsteadOf(item: T, index: Int) {
        data[index] = item
        notifyItemChanged(index)
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }


}