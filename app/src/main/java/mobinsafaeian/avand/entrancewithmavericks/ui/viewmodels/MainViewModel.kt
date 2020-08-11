package mobinsafaeian.avand.entrancewithmavericks.ui.viewmodels

import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import io.reactivex.schedulers.Schedulers
import mobinsafaeian.avand.entrancewithmavericks.model.repositories.NetworkRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainViewModel(
    initialState: ListState
) : BaseViewModel<ListState>(initialState), KoinComponent {

    private val networkRepository: NetworkRepository by inject()

    init {
        setState { copy(list = Loading() ) }

        networkRepository.getList()
            .subscribeOn(Schedulers.io())
            .execute { copy(list = it) }
    }

}