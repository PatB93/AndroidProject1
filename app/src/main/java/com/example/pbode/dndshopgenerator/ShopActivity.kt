package com.example.pbode.dndshopgenerator

import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.pbode.dndshopgenerator.databinding.ActivityShopBinding
import userintent.ShopIntent

class ShopActivity : LifecycleOwner, BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityShopBinding>(this, R.layout.activity_shop)
        val shopIntent = ShopIntent()
        binding.userIntent = shopIntent
        binding.executePendingBindings()
        lifecycle.addObserver(shopIntent)
    }
}