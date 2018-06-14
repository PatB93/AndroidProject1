package service

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.internal.schedulers.ComputationScheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainServiceImpl {
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient().newBuilder().addInterceptor(logging).build()

    var retrofit = Retrofit.Builder()
            .baseUrl("http://www.dnd5eapi.co/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    var service = retrofit.create<MainService>(MainService::class.java)

    fun getEquipment() : Observable<List<EquipmentResponse>> {
        return service.getEquipmentList().subscribeOn(ComputationScheduler()).repeat()
    }
}