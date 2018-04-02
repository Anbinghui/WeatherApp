package com.smallan.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smallan.weatherapp.R
import com.smallan.weatherapp.domain.model.Forecast
import com.smallan.weatherapp.domain.model.ForecastList
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by An on 2018/3/27 0027.
 */
class ForecastListAdapter(val forecastList: ForecastList,val itemClickListener: (Forecast)->Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClickListener)
    }

    override fun getItemCount(): Int {
        return forecastList.size()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        //   holder!!.textview.text = forecastList.dailyForecast.get(0).dawn.get(position)
        /*with(forecastList.get(position)){
            holder!!.textview.text = "$date - 温度:$temperature - 风向: $wind -- 天气: $weather"
        }*/
        holder!!.bindForecast(forecastList.get(position))
    }



    class ViewHolder(view: View,val itemClickListener: (Forecast) ->Unit):RecyclerView.ViewHolder(view) {
        fun bindForecast(forcast: Forecast) {
            with(forcast){
                itemView.icon.setOnClickListener { itemClickListener(this) }
                itemView.icon.setImageResource(R.drawable.ic_launcher)
                itemView.date.text = "天气: $weather"
                itemView.description.text = date
                itemView.maxTemperature.text =  "气温: $temperature"
                itemView.minTemperature.text = "风向: $wind"
            }
        }

    }

}