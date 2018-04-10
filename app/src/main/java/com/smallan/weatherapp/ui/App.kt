package com.smallan.weatherapp.ui

import android.app.Application
import com.smallan.weatherapp.extensions.DelegetesExt

/**
 * Created by An on 2018/4/2 0002.
 */
class App :Application(){
    companion object {
        var instance: App by DelegetesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }




}