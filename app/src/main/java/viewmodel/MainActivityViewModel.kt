package viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent

class MainActivityViewModel {
    val title = "Title"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {

    }

    fun onBackPressed() {

    }
}