package com.dmitriy.android.nbuexchange.presenter


import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity

interface ListPresenterContract {
    interface ListPresenter{
        suspend fun getData():List<CurrencyEntity>

        suspend fun getExchangeEntity(id : Long?):ExchangeEntity

        fun onViewDestroy()

        fun setView(view: ListView)
    }

    interface ListView: BaseView{
//        fun setDataInList(listCurrency : List<CurrencyEntity>?)
    }
}