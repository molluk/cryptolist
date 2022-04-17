package bomond.cryptolist.ui.base.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BaseVH(itemView: View) : RecyclerView.ViewHolder(itemView), FillAction {
    override fun fill(item: Any?) {
        itemView.setOnClickListener {

        }
    }
}