package mobinsafaeian.avand.entrancewithmavericks.ui.viewmodels

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class BaseViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(initialState , debugMode = true)