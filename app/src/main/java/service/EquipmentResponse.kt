package service

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class EquipmentResponse {
    @SerializedName("name")
    val itemName: String = ""

    @SerializedName("url")
    val itemUrl: String = ""
}
data class ItemDescriptionResponse(val itemName: String)