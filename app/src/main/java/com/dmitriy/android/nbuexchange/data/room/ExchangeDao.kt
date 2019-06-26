package com.dmitriy.android.nbuexchange.data.room

import androidx.room.*


@Dao
    interface ExchangeDao {

        @Query("SELECT * FROM currencyentity")
        suspend fun getAll():List<CurrencyEntity>

        @Query("SELECT * FROM exchangeentity WHERE id = :id")
        suspend fun getExchangeById(id : Long?):ExchangeEntity

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertCurrency(entities: List<CurrencyEntity>)

        @Update
        suspend fun updateCurrency(entity: CurrencyEntity)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertExchange(entities: List<ExchangeEntity>)

        @Update
        suspend fun updateExchange(entity: ExchangeEntity)
    }
