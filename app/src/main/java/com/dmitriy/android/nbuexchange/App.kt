package com.dmitriy.android.nbuexchange

import android.app.Application
import androidx.room.Room
import com.dmitriy.android.nbuexchange.dagger.AppComponent
import com.dmitriy.android.nbuexchange.data.room.AppDataBase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder()
            .mainModule(instance)
            .build()
    }

    companion object{
        lateinit var instance :App
        lateinit var component:AppComponent
    }
}