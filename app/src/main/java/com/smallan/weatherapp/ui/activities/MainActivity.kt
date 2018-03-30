package com.smallan.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.smallan.weatherapp.R
import com.smallan.weatherapp.date.service.ForcastServer
import com.smallan.weatherapp.date.service.ServerDataMapper
import com.smallan.weatherapp.domain.model.Forecast
import com.smallan.weatherapp.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRcl :RecyclerView  = find(R.id.rcl_main)
        mainRcl.layoutManager = LinearLayoutManager(this)
        async (){
            val city = "北京"
            val wapper = ServerDataMapper()
            val result = ForcastServer(city,wapper).execute()

            uiThread {
                mainRcl.adapter = ForecastListAdapter(result,object :ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forcast: Forecast) {
                        toast("点击我")
                    }
                })
            }
        }
        // getData(url)
        //copyData()
    }




    /*  fun copyData(){
          val for1 = Forecast(Date(),27f,"123")
          val for2 = for1.copy(temperature = 30f)
          Log.d(javaClass.simpleName,for2.toString())
      }*/

    /*   //调用接口
       fun getData(url:String) {
           async{
               Request(url).exeture()
               uiThread {
                   toast("ok")
               }
           }
       }*/





}
