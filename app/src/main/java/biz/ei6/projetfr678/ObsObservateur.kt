package biz.ei6.projetfr678

import android.util.Log
import androidx.lifecycle.*

class ObsObservateur  : LifecycleObserver ,LifecycleOwner{
    val TAG = "MAIN_OBS_OBSERVATEUR"

    lateinit var lifecycleRegistry : LifecycleRegistry

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(TAG,"onresume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(TAG,"onpause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG,"oncreate")
        lifecycleRegistry = LifecycleRegistry(this)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG,"onstart")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG,"onstop")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG,"ondestroy")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.d(TAG,"onany")

    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}