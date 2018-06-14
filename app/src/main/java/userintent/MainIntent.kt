package userintent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.example.pbode.dndshopgenerator.ShopActivity
import service.EquipmentResponse
import service.MainServiceImpl
import state.MainState
import viewevent.ViewEvent

class MainIntent : LifecycleObserver {

    val serviceRequest : MainServiceImpl = MainServiceImpl()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MainState.title.set("This is the title")
        serviceRequest.getEquipmentList().subscribe({
            for (item in it) {
                print(item.itemName)
            }
        })
    }

    fun onBackPressed() {

    }

    fun click(button: Int) {
        when (button) {
            Buttons.EQUIPMENT -> ViewEvent.startActivity.onNext(ShopActivity::class.java)
            Buttons.ALCHEMY -> onBackPressed()
            Buttons.GENERAL -> onBackPressed()
        }
    }
}

object Buttons {
    val EQUIPMENT = 0
    val ALCHEMY = 1
    val GENERAL = 2
}
