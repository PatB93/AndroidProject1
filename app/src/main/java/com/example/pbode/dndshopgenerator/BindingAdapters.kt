package com.example.pbode.dndshopgenerator

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

@BindingAdapter("customLayoutManager")
fun setLayoutManager(view: RecyclerView, orientation: Int) {
    view.layoutManager = LinearLayoutManager(view.context)
}