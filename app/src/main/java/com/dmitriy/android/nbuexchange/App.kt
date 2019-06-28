package com.dmitriy.android.nbuexchange

import android.app.Application
import com.dmitriy.android.nbuexchange.dagger.AppComponent
import com.dmitriy.android.nbuexchange.dagger.DaggerAppComponent
import com.dmitriy.android.nbuexchange.dagger.MainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .mainModule(MainModule(this))
            .build()
    }

    companion object{
        lateinit var component:AppComponent
    }
}