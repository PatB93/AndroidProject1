package userintent
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import recyclerview.ShopAdapter

class ShopIntent: LifecycleObserver {
    private val intentList = ArrayList<ShopItemIntent>()
    val shopAdapter: ShopAdapter
        get() = ShopAdapter(intentList)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) fun initializeList() {
        for(i in 1..15) {
            intentList.add(ShopItemIntent("shop item $i"))
        }
        shopAdapter.notifyDataSetChanged()
    }
}
