package com.dmitriy.android.nbuexchange.service

import com.dmitriy.android.nbuexchange.data.Currency
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NBUApiService {

    @GET
    suspend fun getCurrentCurrency(
        @Url baseUrl: String,
        @Query("json")value : String
    ): Response<List<Currency>>

    companion object Factory {
        const val BASE_URL = "https://bank.gov.ua/NBUStatService/v1/"

        fun create(): NBUApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NBUApiService::class.java)
        }
    }
}