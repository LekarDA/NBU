package com.dmitriy.android.nbuexchange.presenter


import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import com.dmitriy.android.nbuexchange.repository.Repository

class ListPresenter(private val repository : Repository) :BasePresenter<ListPresenterContract.ListView>(), ListPresenterContract.ListPresenter {

    override fun setView(view: ListPresenterContract.ListView) = viewSetter(view)

    override suspend fun getData():List<CurrencyEntity> {
        return repository.getCurrencyList()
    }

    override suspend fun getExchangeEntity(id: Long?): ExchangeEntity {
        return repository.getExchangeEntity(id)
    }

    override fun onViewDestroy() {
        super.destroy()
    }

}