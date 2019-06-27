package com.dmitriy.android.nbuexchange.dagger


import com.dmitriy.android.nbuexchange.presenter.ListPresenter
import com.dmitriy.android.nbuexchange.repository.RepositoryImplementation
import com.dmitriy.android.nbuexchange.view.MainActivity
import dagger.Component

@Component(modules = arrayOf(MainModule::class))
interface AppComponent {
    fun injectActivity(activity: MainActivity)

    fun injectListPresenter(listPresentor:ListPresenter)

    fun injectRepository(repository: RepositoryImplementation)
}