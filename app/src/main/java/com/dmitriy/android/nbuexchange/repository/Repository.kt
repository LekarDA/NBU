package com.dmitriy.android.nbuexchange.repository

import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity

interface Repository {
    suspend fun getCurrencyList():List<CurrencyEntity>
    suspend fun getExchangeEntity(id:Long?):ExchangeEntity
}