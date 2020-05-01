package biz.ei6.projetfr678

import android.util.Log
import androidx.lifecycle.*

class FragmentObservateur  : LifecycleObserver, LifecycleOwner {
    val TAG = "MAINOBSERVATEUR"

    lateinit var lifecycleRegistry : LifecycleRegistry

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(TAG,"onresume")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(TAG,"onpause")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG,"oncreate")
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG,"onstart")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG,"onstop")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG,"ondestroy")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.d(TAG,"onany")

    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}