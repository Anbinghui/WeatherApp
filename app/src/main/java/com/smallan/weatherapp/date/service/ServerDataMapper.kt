package com.smallan.weatherapp.date.service

import com.smallan.weatherapp.domain.model.Forecast
import com.smallan.weatherapp.domain.model.ForecastList

/**
 * Created by An on 2018/3/29 0029.
 */
 class ServerDataMapper {
     fun convertFromDataModel(forcast: ForecastResult): ForecastList {
        return ForecastList(forcast.result.data.realtime.city_name,convertForecastListToDomain(forcast.result.data.weather))
    }

    private fun convertForecastListToDomain(weather: List<WeatherBean>): List<Forecast> {
        return weather.map { convertForecastItemtoDomain(it) }
    }

    private fun convertForecastItemtoDomain(weatherBean: WeatherBean): Forecast {
        return Forecast(weatherBean.date,weatherBean.nongli,weatherBean.info.dawn,weatherBean.info.day,weatherBean.info.night)
    }
}