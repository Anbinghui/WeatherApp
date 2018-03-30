package com.smallan.weatherapp.date.service

import com.smallan.weatherapp.domain.command.Command
import com.smallan.weatherapp.domain.model.ForecastList

/**
 * Created by An on 2018/3/30 0030.
 */
class ForcastServer(val city: String,private val dataMapper: ServerDataMapper= ServerDataMapper()):Command<ForecastList> {
    override fun execute(): ForecastList {
        val result = Request(city).exeture()
        return dataMapper.convertFromDataModel(result)
    }

}