package com.mcas2.firstdesign

import android.app.Application
import com.google.android.material.color.DynamicColors

class FirstDesignApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}