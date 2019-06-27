package com.dmitriy.android.nbuexchange.repository

import android.util.Log
import com.dmitriy.android.nbuexchange.data.Currency
import com.dmitriy.android.nbuexchange.data.room.AppDataBase
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import com.dmitriy.android.nbuexchange.managers.MappingManager
import com.dmitriy.android.nbuexchange.service.NBUApiService
import javax.inject.Inject

class RepositoryImplementation(val newtworkService : NBUApiService,val mappingManager : MappingManager,val dataBase : AppDataBase): Repository {

    private val BASE_URL = "statdirectory/exchange"



    override suspend fun getCurrencyList(): List<CurrencyEntity> {
        requestToServer()
        return dataBase.exchangeDao().getAll() as ArrayList<CurrencyEntity>
    }

    suspend fun mapData(data: List<Currency>?){
        if(data != null){
            for (currency in data) {
                mappingManager.mapping(currency)
            }
            saveInDatabase(mappingManager.listCurrencyEntity,mappingManager.listExchangeEntity)
        }
    }

    suspend fun saveInDatabase(currencyEntities :List<CurrencyEntity>, exchangeEntities:List<ExchangeEntity>){
        dataBase.exchangeDao().insertCurrency(currencyEntities)
        dataBase.exchangeDao().insertExchange(exchangeEntities)
    }

    suspend fun requestToServer(){
        try {
            val response = newtworkService.getCurrentCurrency(baseUrl = BASE_URL, value = "")
            if (response.isSuccessful){
                mapData(response.body())
            }
            else {
                Log.i("ExchangeApp", "exception" + response.errorBody().toString())
            }
        } catch (e: Exception) {
            Log.i("ExchangeApp", "exception" + e.toString())
        }
    }
}