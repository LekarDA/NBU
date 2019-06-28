package com.dmitriy.android.nbuexchange.data.room


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class ExchangeEntity(@PrimaryKey val id:Int, val exchangeDate:String?, val rate: Double): Parcelable