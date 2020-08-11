package mobinsafaeian.avand.entrancewithmavericks.model.repositories

import io.reactivex.Single
import mobinsafaeian.avand.entrancewithmavericks.model.connections.ApiInterface
import mobinsafaeian.avand.entrancewithmavericks.model.connections.responses.MainResponse
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Response

class NetworkRepository : KoinComponent {

    // Definitions
    private val getApi: ApiInterface by inject()

    /**
     * ------------
     * Functions
     * ------------
     */

    fun getList(): Single<MainResponse> = getApi.fetchList()

}