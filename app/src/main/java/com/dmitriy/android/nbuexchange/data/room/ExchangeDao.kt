package com.dmitriy.android.nbuexchange.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


    @Dao
    interface ExchangeDao {

        @Query("SELECT * FROM currencyentity")
        suspend fun getAll():List<CurrencyEntity>

        @Query("SELECT * FROM exchangeentity WHERE id = :id")
        suspend fun getExchangeById(id : Long?):ExchangeEntity

        @Insert
        suspend fun insertCurrency(entity: CurrencyEntity)

        @Update
        suspend fun updateCurrency(entity: CurrencyEntity)

        @Insert
        suspend fun insertExchange(entity: ExchangeEntity)

        @Update
        suspend fun updateExchange(entity: ExchangeEntity)
    }
