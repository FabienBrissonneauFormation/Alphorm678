package biz.ei6.projetfr678

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainViewModele : ViewModel() {
    val TAG = "MAINVIEWMODELE"

    var date : LocalDate = LocalDate.now()

    var dateTxt : String = ""
        get() = date.format(DateTimeFormatter.ISO_LOCAL_DATE)
        set(value) { field = value; date = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE)}

    var departKM : Int  = 0
        set(value) { field = value; kilometres.value =  arriveeKM-value }

    var departKMTxt : String =""
        get() = ""+departKM
        set(value) {
            field = value; if(value.isNotBlank()) departKM = Integer.parseInt(value) else departKM=0}

    var departLocation : String = ""

    var arriveeKM : Int = 0
        set(value) { field = value; kilometres.value =  value-departKM }

    var arriveeKMTxt : String =""
        get() = ""+arriveeKM
        set(value) { field = value; if(value.isNotBlank()) arriveeKM = Integer.parseInt(value) else arriveeKM = 0 }

    var arriveeLocation : String = ""


    var kilometres = MutableLiveData<Int>()


    fun enregistre() {
        Log.d(TAG, "Ici on enregistrera les données ...")
    }
}