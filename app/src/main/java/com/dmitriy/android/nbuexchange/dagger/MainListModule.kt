package com.dmitriy.android.nbuexchange.dagger

import android.content.Context
import androidx.room.Room
import com.dmitriy.android.nbuexchange.data.room.AppDataBase
import com.dmitriy.android.nbuexchange.data.room.ExchangeDao
import com.dmitriy.android.nbuexchange.presenter.ListPresenter
import com.dmitriy.android.nbuexchange.presenter.ListPresenterContract
import com.dmitriy.android.nbuexchange.repository.Repository
import com.dmitriy.android.nbuexchange.repository.RepositoryImplementation
import com.dmitriy.android.nbuexchange.service.NBUApiService
import dagger.Binds
import dagger.Module

@Module
interface MainListModule {
    @Binds
    @MainScope
    fun provideMainMenuPresenter(listPresenter : ListPresenter): ListPresenterContract.ListPresenter

    @Binds
    @MainScope
    fun provideRepository(repository:RepositoryImplementation): Repository

    @Binds
    @MainScope
    fun provideRepository(service: NBUApiService): NBUApiService

    @Binds
    fun provideDatabaseHelper(dataBase: AppDataBase): ExchangeDao
}