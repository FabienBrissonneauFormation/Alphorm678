package biz.ei6.projetfr678

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val mViewModele : MainViewModele by activityViewModels<MainViewModele>()

    var binding : FirstFragmentBinding?

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false)
        val binding =  DataBindingUtil.inflate(R.layout.fragment_first, container, false)
        binding.setLifecycleOwner(this)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.main_first_button).setOnClickListener {

            valider()

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        main_first_date.append(mViewModele.date.format(DateTimeFormatter.ISO_LOCAL_DATE))
        main_first_arrivee_km.append(mViewModele.arriveeKM.toString())
        main_first_arrivee_location.append(mViewModele.arriveeLocation)
        main_first_depart_km.append(mViewModele.departKM.toString())
        main_first_depart_location.append(mViewModele.departLocation)



    }

    private fun valider() {
        mViewModele.date = LocalDate.parse(main_first_date.text,DateTimeFormatter.ISO_LOCAL_DATE)
        mViewModele.departKM = Integer.parseInt(main_first_depart_km.text.toString())
        mViewModele.arriveeKM = Integer.parseInt(main_first_arrivee_km.text.toString())

        mViewModele.departLocation = main_first_depart_location.text.toString()
        mViewModele.arriveeLocation = main_first_arrivee_location.text.toString()
    }
}
