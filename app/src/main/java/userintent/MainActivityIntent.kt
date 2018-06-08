package userintent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import state.MainActivityState

class MainActivityIntent : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MainActivityState.title.set("This is the title")
    }

    fun onBackPressed() {

    }

    fun click() {
        MainActivityState.title.set("You clicked")
    }
}