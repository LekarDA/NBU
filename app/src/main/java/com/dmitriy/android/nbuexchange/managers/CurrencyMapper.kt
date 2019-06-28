package com.dmitriy.android.nbuexchange.managers

import com.dmitriy.android.nbuexchange.data.Currency
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity

class CurrencyMapper {

     fun map(currency: Currency):Pair<CurrencyEntity,ExchangeEntity>{
        val currencyEntity = CurrencyEntity(id=currency.id + (0..1000000).random(),name = currency.name,code = currency.code)
        val exchangeEntity = (ExchangeEntity(id =currency.id+ (0..1000000).random(),exchangeDate = currency.exchangeDate,rate = currency.rate))
        return currencyEntity to exchangeEntity
     }

    fun map(currencies: List<Currency>): Pair<List<CurrencyEntity>, List<ExchangeEntity>> {
        val currencyEntities = mutableListOf<CurrencyEntity>()
        val exchangeEntities = mutableListOf<ExchangeEntity>()
        currencies.forEach {
            val (currencyEntity, exchangeEntity) = map(it)
            currencyEntities.add(currencyEntity)
            exchangeEntities.add(exchangeEntity)
        }
        return currencyEntities to exchangeEntities
    }
}