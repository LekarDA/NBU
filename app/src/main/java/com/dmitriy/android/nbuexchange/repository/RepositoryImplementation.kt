package com.dmitriy.android.nbuexchange.repository


import com.dmitriy.android.nbuexchange.data.room.AppDataBase
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import com.dmitriy.android.nbuexchange.managers.CurrencyMapper
import com.dmitriy.android.nbuexchange.service.NBUApiService
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val newtworkService : NBUApiService,
    private val currencyMapper : CurrencyMapper,
    private val dataBase : AppDataBase): Repository {


    override suspend fun getCurrencyList(): List<CurrencyEntity> {
        val currency = newtworkService.getCurrentCurrency()
        val (currencyEntities, exchangeEntities) = currencyMapper.map(currency)
        dataBase.exchangeDao.insertCurrency(currencyEntities)
        dataBase.exchangeDao.insertExchange(exchangeEntities)
        return dataBase.exchangeDao.getAllCurrencies()
    }

    override suspend fun getExchangeEntity(id: Long?): ExchangeEntity = dataBase.exchangeDao.getExchangeById(id)

}