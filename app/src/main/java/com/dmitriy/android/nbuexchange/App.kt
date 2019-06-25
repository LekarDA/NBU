package com.dmitriy.android.nbuexchange

import android.app.Application
import androidx.room.Room
import com.dmitriy.android.nbuexchange.data.room.AppDataBase

class App: Application() {
    var dataBase:AppDataBase?=null

    override fun onCreate() {
        super.onCreate()
        instance = this
        dataBase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database").build()
    }

    companion object{
        lateinit var instance :App
    }
}