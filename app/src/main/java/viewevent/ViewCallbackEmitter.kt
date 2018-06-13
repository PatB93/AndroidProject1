package viewevent

import android.support.v7.app.AppCompatActivity
import io.reactivex.subjects.PublishSubject

object ViewEvent {
    val startActivity : PublishSubject<Class<*>> = PublishSubject.create()
}
