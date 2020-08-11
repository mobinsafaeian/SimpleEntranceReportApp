package mobinsafaeian.avand.entrancewithmavericks.ui.viewmodels

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import mobinsafaeian.avand.entrancewithmavericks.model.connections.responses.MainResponse
import retrofit2.Response

data class ListState(
    val list: Async<MainResponse> = Uninitialized
) : MvRxState