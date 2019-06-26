package com.dmitriy.android.nbuexchange.data.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CurrencyEntity(@PrimaryKey val id : Int, val name : String?, val code : String?): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrencyEntity> {
        override fun createFromParcel(parcel: Parcel): CurrencyEntity {
            return CurrencyEntity(parcel)
        }

        override fun newArray(size: Int): Array<CurrencyEntity?> {
            return arrayOfNulls(size)
        }
    }
}