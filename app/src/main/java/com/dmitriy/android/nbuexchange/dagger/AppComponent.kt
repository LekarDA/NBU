package com.dmitriy.android.nbuexchange.dagger


import com.dmitriy.android.nbuexchange.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {
    fun injectActivity(activity: MainActivity)

//    fun injectListPresenter(listPresentor: ListPresenter)

}