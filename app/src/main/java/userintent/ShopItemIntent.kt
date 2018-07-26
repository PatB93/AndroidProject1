package userintent

import android.databinding.ObservableField

class ShopItemIntent(name: String) {
    val itemName = ObservableField<String>(name)
}