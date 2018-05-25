package userintent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent

class MainActivityIntent {
    var title = String()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        title = "this is the title"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {

    }

    fun onBackPressed() {

    }
}