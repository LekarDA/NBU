package com.dmitriy.android.nbuexchange.repository

import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity

interface Repository {
    suspend fun getCurrencyList():List<CurrencyEntity>
}