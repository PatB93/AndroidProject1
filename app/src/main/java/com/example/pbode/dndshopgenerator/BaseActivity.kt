package com.example.pbode.dndshopgenerator

import android.content.Intent
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    fun startActivity(activity: Class<*>) {
        startActivity(Intent(this, activity))
    }
}