package userintent

import android.databinding.ObservableField
import android.databinding.ObservableInt

class ShopItemIntent(name: String) {
    val itemName = ObservableField<String>(name)
    val itemQuantity = ObservableField<String>("0")
    var quantity = 0
    fun increment() {
        quantity += 1
        itemQuantity.set("$quantity")
    }
    fun decrement() {
        if (quantity > 0) {
            quantity -= 1
            itemQuantity.set("$quantity")
        }
    }
}