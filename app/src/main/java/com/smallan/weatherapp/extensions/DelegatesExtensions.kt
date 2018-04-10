package com.smallan.weatherapp.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by An on 2018/4/4 0004.
 */
object DelegetesExt{
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

 class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?,T> {

    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?:throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }

}