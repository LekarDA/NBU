package com.dmitriy.android.nbuexchange.presenter


import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity

interface ListPresenterContract {
    interface ListPresenter{
        fun loadData()

        fun onViewDestroy()

        fun setView(view: ListView)
    }

    interface ListView: BaseView{
        fun setDataInList(listCurrency : List<CurrencyEntity>?)
    }
}