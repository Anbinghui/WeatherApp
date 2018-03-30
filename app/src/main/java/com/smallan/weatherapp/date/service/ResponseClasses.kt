package com.smallan.weatherapp.date.service

/**
 * Created by An on 2018/3/27 0027.
 */
data class ForecastResult(val reason:String, val result: ResultData, val error_code:Int)
data class ResultData(val data: DataBean)
data class DataBean(val weather:List<WeatherBean>,val realtime: RealTimeBean)
data class WeatherBean(val date: String, val info: InfoBean, val week: String, val nongli: String)
data class InfoBean(val dawn: List<String>,val day: List<String>,val night: List<String>)

data class RealTimeBean(val city_code:String,val city_name: String,val date: String)