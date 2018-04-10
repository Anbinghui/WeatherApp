package com.smallan.weatherapp.date.db

import com.smallan.weatherapp.domain.model.ForecastList
import com.smallan.weatherapp.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by An on 2018/4/8 0008.
 */
class ForecastDB(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByCity(city: String,date: String) = forecastDbHelper.use {
        val dailyRequest = "${DayForcastTable.CITY} = ? AND ${DayForcastTable.DATE} >= ?"
        val dailyForecast = select(DayForcastTable.NAME).
                whereSimple(dailyRequest,city,date)
                .parseList{ DayForcast(HashMap(it))}

        val city = select(CityForecastTable.NAME).
                whereSimple("${CityForecastTable.ID} = ?",city.toString()).
                parseOpt{ CityForecast(HashMap(it),dailyForecast)}
        city?.let { dataMapper.convertDomain(it) }
    }


    fun requestDayForecast(id : Long) = forecastDbHelper.use {
        val forecast = select(DayForcastTable.NAME).byId(id).
                parseOpt{ DayForcast(HashMap(it)) }
        forecast?.let { dataMapper.convertDayToDomain(it) }
    }

    fun saveForecast(forecastList: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForcastTable.NAME)

        with(dataMapper.convertFromDomain(forecastList)){
            insert(CityForecastTable.NAME,*map.toVararyArray())
            dailyForecast.forEach {
                insert(DayForcastTable.NAME,*it.map.toVararyArray())
            }
        }
    }
}