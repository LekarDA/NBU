package com.dmitriy.android.nbuexchange.presenter

import android.view.View
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPresenter :BasePresenter<ListPresenterContract.ListView>(), ListPresenterContract.ListPresenter {

    @Inject
    lateinit var repository: Repository

    override fun setView(view: ListPresenterContract.ListView) = viewSetter(view)

    override fun getData(): List<CurrencyEntity> ?{
        var list : List<CurrencyEntity>? = null
        launch {
          async {list =  repository.getCurrencyList()}.await()
        }
        return list
    }

    override fun onViewDestroy() {
        super.destroy()
    }

}