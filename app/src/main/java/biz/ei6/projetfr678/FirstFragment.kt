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
import androidx.navigation.fragment.findNavController
import biz.ei6.projetfr678.databinding.FragmentFirstBinding
import biz.ei6.projetfr678.BR.mainViewModele


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
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false)
        binding =  DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)
        binding.lifecycleOwner = this
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

        binding.setVariable(mainViewModele,mViewModele)

        val obs = FragmentObservateur()
        lifecycle.addObserver(obs)

        obs.lifecycle.addObserver(ObsObservateur())

    }

    private fun valider() {


    }
}
