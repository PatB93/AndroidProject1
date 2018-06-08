package service

import retrofit2.Call
import retrofit2.http.GET

interface MainService {
    @GET("/api/equipment/")
    fun getEquipment(): Call<EquipmentResponse>

    @GET("/api/equipment/{id}")
    fun getItem(id: Int): Call<ItemResponse>
}