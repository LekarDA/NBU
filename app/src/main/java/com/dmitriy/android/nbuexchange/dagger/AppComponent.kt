package com.dmitriy.android.nbuexchange.dagger


import com.dmitriy.android.nbuexchange.presenter.ListPresenterImpl
import com.dmitriy.android.nbuexchange.repository.RepositoryImplementation
import com.dmitriy.android.nbuexchange.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainModule::class/*MainListModule::class*/))
interface AppComponent {
    fun injectActivity(activity: MainActivity)

    fun injectListPresenter(listPresentor: ListPresenterImpl)

}