package com.smallan.weatherapp.date.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.smallan.weatherapp.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by An on 2018/4/4 0004.
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION) {
    companion object {
        val DB_NAME = "forecast_db"
        val DB_VERSION = 1
        val instance :ForecastDbHelper by lazy {
            ForecastDbHelper()
        }
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME,true,
                CityForecastTable.ID to INTEGER+ PRIMARY_KEY + AUTOINCREMENT,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.CITY_CODE to  TEXT,
                CityForecastTable.DATE to  TEXT)
        db.createTable(DayForcastTable.NAME, true,
                DayForcastTable.ID to INTEGER+ PRIMARY_KEY+ AUTOINCREMENT,
                DayForcastTable.CITY to TEXT,
                DayForcastTable.DATE to TEXT,
                DayForcastTable.TEMPERATURE to TEXT,
                DayForcastTable.WEATHER to TEXT,
                DayForcastTable.WIND to TEXT)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME,true)
        db.dropTable(DayForcastTable.NAME,true)
        onCreate(db)
    }



}
