package biz.ei6.projetfr678

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import biz.ei6.projetfr678.databinding.FragmentFirstBinding
import biz.ei6.projetfr678.BR.mainViewModele
import kotlinx.android.synthetic.main.fragment_first.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val mViewModele : MainViewModele by activityViewModels<MainViewModele>()

    lateinit var binding : FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding =  DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)
        binding.lifecycleOwner = this
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.main_first_button).setOnClickListener {

            valider()

            //val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(main_first_depart_location.text.toString())

            val voyage = Voyage(LocalDate.parse(main_first_date.text.toString(), DateTimeFormatter.ISO_LOCAL_DATE),
                                main_first_depart_location.text.toString(),
                                Integer.parseInt(main_first_depart_km.text.toString()),
                                main_first_arrivee_location.text.toString(),
                                Integer.parseInt(main_first_arrivee_km.text.toString()))

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(voyage)
            findNavController().navigate(action)

        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.setVariable(mainViewModele,mViewModele)

        val obs = FragmentObservateur()
        lifecycle.addObserver(obs)

    }

    private fun valider() {


    }
}
