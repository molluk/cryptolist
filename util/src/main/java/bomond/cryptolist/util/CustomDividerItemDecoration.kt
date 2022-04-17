package bomond.cryptolist.util

import android.graphics.Rect
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class CustomDividerItemDecoration(
    var context: android.content.Context,
    myOrientation: Int
) : DividerItemDecoration(context, myOrientation) {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            outRect.setEmpty()
        } else {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }

    fun get8dp(): DividerItemDecoration {
        this.setDrawable(
            AppCompatResources.getDrawable(
                context,
                R.drawable.divider_in_horizontal_recycler_8dp
            )!!
        )
        return this
    }

    fun get8dp(color: Boolean): DividerItemDecoration {
        return if (color) {
            this.setDrawable(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.divider_in_horizontal_recycler_line_1dp
                )!!
            )
            return this
        } else {
            get8dp()
        }
    }
}