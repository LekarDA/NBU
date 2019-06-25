package com.dmitriy.android.nbuexchange.managers

import com.dmitriy.android.nbuexchange.data.Currency
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import java.util.ArrayList

class MappingManager {
    var listCurrencyEntity = ArrayList<CurrencyEntity>()
    var listExchangeEntity = ArrayList<ExchangeEntity>()


    suspend fun mapping(currency: Currency){
        listCurrencyEntity.add(CurrencyEntity(currency.id,currency.name,currency.code))
        listExchangeEntity.add(ExchangeEntity(currency.id,currency.exchangeDate,currency.rate))
    }
}