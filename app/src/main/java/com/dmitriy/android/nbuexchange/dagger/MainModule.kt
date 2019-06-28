package com.dmitriy.android.nbuexchange.dagger

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dmitriy.android.nbuexchange.data.room.AppDataBase
import com.dmitriy.android.nbuexchange.managers.CurrencyMapper
import com.dmitriy.android.nbuexchange.presenter.ListPresenterContract
import com.dmitriy.android.nbuexchange.presenter.ListPresenter
import com.dmitriy.android.nbuexchange.repository.Repository
import com.dmitriy.android.nbuexchange.repository.RepositoryImplementation
import com.dmitriy.android.nbuexchange.service.NBUApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainModule(private val application: Application) {


    @Provides
    fun providePresentor(repository : Repository):ListPresenterContract.ListPresenter = ListPresenter(repository)


    @Provides
    @Singleton
    fun provideRepository(nbuApiService: NBUApiService,currencyMapper: CurrencyMapper,appDataBase: AppDataBase): Repository =
        RepositoryImplementation(nbuApiService,currencyMapper,appDataBase)


    @Provides
    fun provideNetworkUtils(): NBUApiService = NBUApiService.create()


    @Provides
    fun provideMapper():CurrencyMapper = CurrencyMapper()


    @Provides
    @Singleton
    fun provideDatabaseHelper(applicationContext: Context): AppDataBase =
        Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database").build()


    @Provides
    fun provideContext(): Context = application.applicationContext

}