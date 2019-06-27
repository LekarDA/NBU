package com.dmitriy.android.nbuexchange.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrencyEntity::class,ExchangeEntity::class], version = 1,exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun exchangeDao():ExchangeDao
}