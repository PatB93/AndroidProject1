package userintent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import com.example.pbode.dndshopgenerator.ShopActivity
import service.FirebaseProvider
import state.MainState
import viewevent.ViewEvent

class MainIntent : LifecycleObserver {
    val database = FirebaseProvider()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MainState.title.set("This is the title")
    }

    private fun getStuff() {
        print(database.item.subscribe{ Log.d("asdf", it.name)}.dispose())
    }

    fun onBackPressed() {

    }

    fun click(button: Int) {
        when (button) {
            Buttons.EQUIPMENT -> ViewEvent.startActivity.onNext(ShopActivity::class.java)
            Buttons.ALCHEMY -> getStuff()
            Buttons.GENERAL -> onBackPressed()
        }
    }
}

object Buttons {
    const val EQUIPMENT = 0
    const val ALCHEMY = 1
    const val GENERAL = 2
}
