package com.example.pbode.dndshopgenerator

import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.pbode.dndshopgenerator.databinding.ActivityMainBinding
import state.MainState
import userintent.MainIntent
import viewevent.ViewEvent

class MainActivity : LifecycleOwner, BaseActivity() {

    val mainIntent = MainIntent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.userIntent = mainIntent
        binding.state = MainState
        lifecycle.addObserver(mainIntent)

        ViewEvent.startActivity.subscribe({startActivity(it)})
    }
}