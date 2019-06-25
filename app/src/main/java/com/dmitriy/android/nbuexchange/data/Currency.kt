package com.dmitriy.android.nbuexchange.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("r030")
    val id: Int,
    @SerializedName("txt")
    val name: String?,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("cc")
    val code: String?,
    @SerializedName("exchangedate")
    val exchangeDate: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeDouble(rate)
        parcel.writeString(code)
        parcel.writeString(exchangeDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Currency> {
        override fun createFromParcel(parcel: Parcel): Currency {
            return Currency(parcel)
        }

        override fun newArray(size: Int): Array<Currency?> {
            return arrayOfNulls(size)
        }
    }
}