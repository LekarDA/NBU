package com.dmitriy.android.nbuexchange.data.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ExchangeEntity(@PrimaryKey val id:Int, val exchangeDate:String?, val rate: Double): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(exchangeDate)
        parcel.writeDouble(rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExchangeEntity> {
        override fun createFromParcel(parcel: Parcel): ExchangeEntity {
            return ExchangeEntity(parcel)
        }

        override fun newArray(size: Int): Array<ExchangeEntity?> {
            return arrayOfNulls(size)
        }
    }
}