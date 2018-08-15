package userintent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import recyclerview.ShopAdapter
import service.FirebaseProvider

class ShopIntent : LifecycleObserver {
    private val database = FirebaseProvider()
    private val intentList = ArrayList<ShopItemIntent>()

    private val shopAdapter = ShopAdapter(intentList)

    fun getShopAdapter() : ShopAdapter {
        return shopAdapter
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun initializeList() {
        intentList.add(ShopItemIntent("PLEASE FUCKING WORK"))
        database.equipment.flatMapIterable { it }
                .subscribe {
                    intentList.add(ShopItemIntent(it.name))
                    updateView()
                }
        shopAdapter.notifyDataSetChanged()
    }

    fun updateView() {shopAdapter.notifyDataSetChanged()}
}
