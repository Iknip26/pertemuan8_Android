package com.example.tiketapp_uts

import android.os.Parcel
import android.os.Parcelable

data class movie(val thumbnail:Int, val name: String?, val genre: String?,  val sutradara:String?, val rate:Int, val rate_txt:String?, val deskripsiFilm: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(thumbnail)
        parcel.writeString(name)
        parcel.writeString(genre)
        parcel.writeString(sutradara)
        parcel.writeInt(rate)
        parcel.writeString(rate_txt)
        parcel.writeString(deskripsiFilm)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<movie> {
        override fun createFromParcel(parcel: Parcel): movie {
            return movie(parcel)
        }

        override fun newArray(size: Int): Array<movie?> {
            return arrayOfNulls(size)
        }
    }
}
