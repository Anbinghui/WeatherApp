package com.smallan.weatherapp.date.db

import com.smallan.weatherapp.domain.model.Forecast
import com.smallan.weatherapp.domain.model.ForecastList

/**
 * Created by An on 2018/4/8 0008.
 */
class DbDataMapper {

    fun convertFromDomain(forecast: ForecastList)= with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(city,it) }
        CityForecast(city,date,city_code,daily)
    }

    private fun convertDayFromDomain(city: String, it: Forecast) = with(it) {
        DayForcast(city,weather,date,wind,temperature)
    }

    fun convertDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(city,daily,date,city_code)
    }

     fun convertDayToDomain(it: DayForcast)=  with(it) {
        Forecast(date,temperature,wind,weather)
    }

}