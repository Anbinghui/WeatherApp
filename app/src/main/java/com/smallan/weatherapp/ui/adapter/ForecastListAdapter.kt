package com.smallan.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.smallan.weatherapp.domain.model.ForecastList

/**
 * Created by An on 2018/3/27 0027.
 */
class ForecastListAdapter(val forecastList: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent!!.context))
    }

    override fun getItemCount(): Int {
        return forecastList.size()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
     //   holder!!.textview.text = forecastList.dailyForecast.get(0).dawn.get(position)
        with(forecastList.get(position)){
            holder!!.textview.text = "$date - 早上:${dawn.get(1)} - 白天: ${day.get(1)} - 晚上: ${night.get(1)}"
        }
    }



    class ViewHolder(val textview:TextView):RecyclerView.ViewHolder(textview)


}