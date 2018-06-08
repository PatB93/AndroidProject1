package com.example.pbode.dndshopgenerator

import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pbode.dndshopgenerator.databinding.ActivityMainBinding
import state.MainActivityState
import userintent.MainActivityIntent

class MainActivity : LifecycleOwner, AppCompatActivity() {

    val mainActivityIntent = MainActivityIntent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.userIntent = mainActivityIntent
        binding.state = MainActivityState
        lifecycle.addObserver(mainActivityIntent)
    }
}