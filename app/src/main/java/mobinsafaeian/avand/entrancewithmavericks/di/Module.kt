package mobinsafaeian.avand.entrancewithmavericks.di

import mobinsafaeian.avand.entrancewithmavericks.model.Const
import mobinsafaeian.avand.entrancewithmavericks.model.connections.ApiInterface
import mobinsafaeian.avand.entrancewithmavericks.model.connections.RetrofitBuilder
import mobinsafaeian.avand.entrancewithmavericks.model.repositories.NetworkRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module.module


val applicationModule = module(override = true) {

    /**
     * ---------
     * Single Objects Section
     * that generated single objects
     * ---------
     */

    single<OkHttpClient> {
        RetrofitBuilder.getOkHttpClient()
    }

    single<ApiInterface> {
        RetrofitBuilder.create(Const.BASE_URL , get())
    }

    single<NetworkRepository> {
        NetworkRepository()
    }
}