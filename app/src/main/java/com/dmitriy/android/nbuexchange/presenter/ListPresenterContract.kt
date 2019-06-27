package com.dmitriy.android.nbuexchange.presenter


import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity

interface ListPresenterContract {
    interface ListPresenter{
        fun getData():List<CurrencyEntity>?

        fun onViewDestroy()

        fun setView(view: ListView)
    }

    interface ListView: BaseView{
        fun setDataInList(listCurrency : ArrayList<CurrencyEntity>)
    }
}