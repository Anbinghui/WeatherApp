package com.smallan.weatherapp.domain.model

/**
 * Created by An on 2018/3/29 0029.
 */

data class ForecastList(val city: String,val dailyForecast: List<Forecast>) {
    operator fun get(position: Int):Forecast = dailyForecast.get(position)
    fun size():Int = dailyForecast.size
}
data class Forecast(val date: String, val nongli: String,val dawn: List<String>,val day: List<String>,val night: List<String>)