package com.dmitriy.android.nbuexchange.dagger

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dmitriy.android.nbuexchange.data.room.AppDataBase
import com.dmitriy.android.nbuexchange.managers.MappingManager
import com.dmitriy.android.nbuexchange.presenter.ListPresenter
import com.dmitriy.android.nbuexchange.repository.RepositoryImplementation
import com.dmitriy.android.nbuexchange.service.NBUApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainModule(private val application: Application) {

    @Provides
    @Singleton
    fun providePresentor():ListPresenter{
        return ListPresenter()
    }

    @Provides
    @Singleton
    fun provideRepository():RepositoryImplementation{
        return RepositoryImplementation(provideNetworkUtils(),provideMapper(),provideDatabaseHelper(provideContext()))
    }

    @Provides
    @Singleton
    fun provideNetworkUtils(): NBUApiService {
        return NBUApiService.create()
    }

    @Provides
    fun provideMapper():MappingManager{
        return MappingManager()
    }

    @Provides
    @Singleton
    fun provideDatabaseHelper(applicationContext: Context): AppDataBase {
        return Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }
}