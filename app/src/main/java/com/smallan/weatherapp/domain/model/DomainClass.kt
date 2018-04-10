package com.smallan.weatherapp.domain.model

/**
 * Created by An on 2018/3/29 0029.
 */

data class ForecastList(val city: String,val dailyForecast: List<Forecast>,val date: String,val city_code: String) {
    fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}
data class Forecast(val date: String,val temperature: String,val wind: String,val weather: String) {

}