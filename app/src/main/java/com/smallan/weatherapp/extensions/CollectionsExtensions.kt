package com.smallan.weatherapp.extensions

/**
 * Created by An on 2018/4/10 0010.
 */
fun <K,V : Any> Map<K,V?>.toVararyArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!)}).toTypedArray()

