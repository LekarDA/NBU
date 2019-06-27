package com.dmitriy.android.nbuexchange.presenter

import com.dmitriy.android.nbuexchange.App
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPresenterImpl :BasePresenter<ListPresenterContract.ListView>(), ListPresenterContract.ListPresenter {

    @Inject
    lateinit var repository: Repository

    override fun setView(view: ListPresenterContract.ListView) = viewSetter(view)

    override fun loadData(){
        var list : List<CurrencyEntity>? = null
        launch {
          list =  repository.getCurrencyList()
        }
        view?.setDataInList(list)
    }

    override fun onViewDestroy() {
        super.destroy()
    }


    init {
        App.component.injectListPresenter(this)
    }

}