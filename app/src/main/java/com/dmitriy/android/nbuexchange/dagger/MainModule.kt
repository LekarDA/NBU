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
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton


@Module
class MainModule(private val application: Application) {



    @Provides
    @Singleton
    @MainScope
    fun providePresentor():ListPresenter{
        return ListPresenter()
    }

    @Provides
    @Singleton
    @MainScope
    @NotNull
    fun provideRepository():RepositoryImplementation{
        return RepositoryImplementation(provideNetworkUtils(),provideMapper(),provideDatabaseHelper(provideContext()))
    }

    @Provides
    @Singleton
    @MainScope
    fun provideNetworkUtils(): NBUApiService {
        return NBUApiService.create()
    }

    @Provides
    @MainScope
    fun provideMapper():MappingManager{
        return MappingManager()
    }

    @Provides
    @Singleton
    @MainScope
    fun provideDatabaseHelper(applicationContext: Context): AppDataBase {
        return Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database").build()
    }

    @Provides
    @Singleton
    @MainScope
    fun provideContext(): Context {
        return application.applicationContext
    }
}