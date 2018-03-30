package com.smallan.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.smallan.weatherapp.R
import com.smallan.weatherapp.domain.model.Forecast
import com.smallan.weatherapp.domain.model.ForecastList
import org.jetbrains.anko.find

/**
 * Created by An on 2018/3/27 0027.
 */
class ForecastListAdapter(val forecastList: ForecastList,val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
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



    class ViewHolder(view: View,val itemClickListener: OnItemClickListener):RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView
        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forcast: Forecast) {
            with(forcast){
                dateView.text = "天气: $weather"
                descriptionView.text = date
                maxTemperatureView.text = "气温: $temperature"
                minTemperatureView.text = "风向: $wind"
                iconView.setImageResource(R.drawable.ic_launcher)
                iconView.setOnClickListener { itemClickListener }
            }
        }

    }
    public interface OnItemClickListener{
        operator fun invoke(forcast: Forecast)
    }
}