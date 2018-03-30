package com.smallan.weatherapp.domain.command

/**
 * Created by An on 2018/3/27 0027.
 */
interface Command<T> {
    fun execute():T
}