package mobinsafaeian.avand.entrancewithmavericks.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.fragment_main.*
import mobinsafaeian.avand.entrancewithmavericks.R
import mobinsafaeian.avand.entrancewithmavericks.model.Const
import mobinsafaeian.avand.entrancewithmavericks.ui.viewmodels.ListState
import mobinsafaeian.avand.entrancewithmavericks.ui.viewmodels.MainViewModel
import mobinsafaeian.avand.entrancewithmavericks.utils.toast

class MainFragment : BaseMvRxFragment() {

    // Definitions
    private val viewModel: MainViewModel by activityViewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main , container , false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    /**
     * Whenever the state changed, this method will be called to update the view.
     */
    override fun invalidate() = withState(viewModel) { state ->
        when (state.list) {
            is Loading -> {
                main_fragment_progress_bar.isVisible = true
                main_fragment_recycler_view.isVisible = false
            }

            is Success -> {
                main_fragment_progress_bar.isVisible = false
                main_fragment_recycler_view.isVisible = true

                // RecyclerView Initializations
                initRecyclerView(state)
            }

            is Fail -> {
                main_fragment_progress_bar.isVisible = false
                main_fragment_recycler_view.isVisible = false
                Const.CONNECTION_PROBLEM toast requireContext()
            }
        }
    }


    /**
     * RecyclerView Initializations
     */
    private fun initRecyclerView(state: ListState) {
        main_fragment_recycler_view.buildModelsWith { controller ->
            state.list.invoke()?.list?.forEachIndexed { index, rollCall ->
                controller.recyclerViewRow {
                    id(index)
                    name(rollCall.username)
                    enterTime(rollCall.entrance)
                    exitTime(rollCall.exit)
                    clickListener { _ -> index.toString() toast requireContext() }
                }
            }
        }
    }
}