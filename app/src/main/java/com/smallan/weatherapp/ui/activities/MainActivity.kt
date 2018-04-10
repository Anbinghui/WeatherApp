package com.smallan.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.smallan.weatherapp.R
import com.smallan.weatherapp.date.service.ForcastServer
import com.smallan.weatherapp.date.service.ServerDataMapper
import com.smallan.weatherapp.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
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
        rcl_main.layoutManager = LinearLayoutManager(this)
        async {
            val city = "北京"
            val wapper = ServerDataMapper()
            val result = ForcastServer(city,wapper).execute()

            uiThread {
                rcl_main.adapter = ForecastListAdapter(result){forecast -> toast("天气"+forecast.weather) }
            }
        }
        // getData(url)
        //copyData()
        val list = listOf(1,2,3,4,5,6)
        assert(list.any { it>10 })
        list.count { it>3 }
        list.forEach { Log.i("TAG",it.toString()) }
        list.forEachIndexed { index, value -> Log.i("TAG","index:"+index+" value:"+value) }

        val name:String = "Smallan"

        val a: Int? = null
        a?.toString()
        a!!.toString()

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
