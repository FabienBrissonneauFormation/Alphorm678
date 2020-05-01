package biz.ei6.projetfr678

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate

data class Voyage(val date : LocalDate, val departLocation : String, val departKM : Int, val arriveeLocation : String, val arriveeKM : Int)  :
    Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("date"),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(departLocation)
        parcel.writeInt(departKM)
        parcel.writeString(arriveeLocation)
        parcel.writeInt(arriveeKM)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Voyage> {
        override fun createFromParcel(parcel: Parcel): Voyage {
            return Voyage(parcel)
        }

        override fun newArray(size: Int): Array<Voyage?> {
            return arrayOfNulls(size)
        }
    }


}