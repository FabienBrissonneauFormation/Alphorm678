package biz.ei6.projetfr678

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class MainViewModele : ViewModel() {

    var date : LocalDate = LocalDate.now()

    var departKM : Int  = 0
        set(value) { field = value; kilometres.value =  arriveeKM-value }

    var departLocation : String = ""

    var arriveeKM : Int = 0
        set(value) { field = value; kilometres.value =  value-departKM }

    var arriveeLocation : String = ""


    var kilometres = MutableLiveData<Int>()

}