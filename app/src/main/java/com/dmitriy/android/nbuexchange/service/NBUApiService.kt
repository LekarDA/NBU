package com.dmitriy.android.nbuexchange.service

import com.dmitriy.android.nbuexchange.data.Currency
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NBUApiService {

    @GET("/NBUStatService/v1/statdirectory/exchange?json")
    suspend fun getCurrentCurrency(): List<Currency>

    companion object Factory {
        const val BASE_URL = "https://bank.gov.ua"

        fun create(): NBUApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NBUApiService::class.java)
        }
    }
}