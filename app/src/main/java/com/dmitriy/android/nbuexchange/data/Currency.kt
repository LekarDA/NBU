package com.dmitriy.android.nbuexchange.data

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("r030") val id: Int,
    @SerializedName("txt") val name: String?,
    @SerializedName("rate") val rate: Double,
    @SerializedName("cc") val code: String?,
    @SerializedName("exchangedate") val exchangeDate: String?
)