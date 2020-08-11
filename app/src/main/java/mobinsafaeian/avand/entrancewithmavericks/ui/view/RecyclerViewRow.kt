package mobinsafaeian.avand.entrancewithmavericks.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import mobinsafaeian.avand.entrancewithmavericks.R


@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class RecyclerViewRow @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?= null,
    defStyle:Int = 0
) : FrameLayout(context , attributeSet , defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.recycler_view_item , this , true)
    }


    @TextProp
    fun setName(name: CharSequence) {
        recycler_view_item_username.text = name
    }


    @TextProp
    fun setEnterTime(enterTime: CharSequence) {
        recycler_view_item_entrance.text = enterTime
    }


    @TextProp
    fun setExitTime(exitTime: CharSequence) {
        recycler_view_item_exit.text = exitTime
    }


    @CallbackProp
    fun setClickListener(listener: OnClickListener?) {
        recycler_view_item_container.setOnClickListener(listener)
    }
}