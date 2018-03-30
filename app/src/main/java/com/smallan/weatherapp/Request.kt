package com.smallan.weatherapp

import android.util.Log
import com.google.gson.Gson
import com.smallan.weatherapp.date.service.ForecastResult
import java.net.URL

/**
 * Created by An on 2018/3/27 0027.
 */
class Request(val cityName:String) {
   /* public fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }*/

    companion object {
        private val APP_ID ="95ded9d5e487c6750dd1aaedb256cbb3"
        private val URL = "http://op.juhe.cn/onebox/weather/query?"
        private val COMPLETE_URL = "$URL&key=$APP_ID&cityname="
    }

    fun exeture(): ForecastResult {
        Log.d(javaClass.simpleName, COMPLETE_URL+cityName)
        val forecastJsonStr = URL(COMPLETE_URL+cityName).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }



}