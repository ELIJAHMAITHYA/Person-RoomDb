package com.example.roomdb

import android.app.Application
import com.example.roomdb.Data.AppContainer
import com.example.roomdb.Data.AppDataContainer

class Person_Application : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}