package service

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface MainService {
    @GET("api/equipment")
    fun getEquipmentList(): Observable<List<EquipmentResponse>>

    @GET("api/equipment/{id}")
    fun getItem(id: Int): Observable<ItemResponse>
}