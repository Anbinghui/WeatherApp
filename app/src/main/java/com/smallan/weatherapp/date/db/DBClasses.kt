package com.smallan.weatherapp.date.db

/**
 * Created by An on 2018/4/8 0008.
 */
class CityForecast(val map:MutableMap<String,Any?>,val dailyForecast: List<DayForcast>) {
    var _id: Long by map
    var city: String by map
    var date: String by map
    var city_code: String by map
    constructor(city: String,date: String,city_code: String,dailyForecast: List<DayForcast>): this(HashMap(),dailyForecast) {
        this.city = city
        this.date = date
        this.city_code = city_code
    }
}

class DayForcast(val map: MutableMap<String,Any?>) {
    var _id: Long by map
    var city_name: String by map
    var weather: String by map
    var date: String by map
    var wind: String by map
    var temperature: String by map
    constructor(city_name: String,weather: String,date: String,wind:String,temperature: String):this(HashMap()) {
        this.date =date
        this.city_name = city_name
        this.weather = weather
        this.wind = wind
        this.temperature = temperature
    }
}