package biz.ei6.projetfr678

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.transition.Scene
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import biz.ei6.projetfr678.BR.mainViewModele
import biz.ei6.projetfr678.databinding.FragmentFirstScene1Binding
import biz.ei6.projetfr678.databinding.FragmentFirstScene2Binding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first_scene1.*
import kotlinx.android.synthetic.main.fragment_first_scene1.main_first_date
import kotlinx.android.synthetic.main.fragment_first_scene1.main_first_depart_km
import kotlinx.android.synthetic.main.fragment_first_scene1.main_first_depart_location
import kotlinx.android.synthetic.main.fragment_first_scene2.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val mViewModele: MainViewModele by activityViewModels<MainViewModele>()

    lateinit var binding: FragmentFirstScene1Binding

    lateinit var scene1 : Scene

    lateinit var scene2 : Scene

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentFirstScene1Binding>(
            inflater,
            R.layout.fragment_first_scene1,
            main_first_racine,
            false
        )
        binding.lifecycleOwner = this
        binding.setVariable(mainViewModele, mViewModele)
        binding.executePendingBindings();
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.setVariable(mainViewModele, mViewModele)

        val btn = view.findViewById<Button>(R.id.main_first_button)
        btn?.setOnClickListener {
            valider()
        }

        val btnPartir = view.findViewById<Button>(R.id.main_first_partir)
        btnPartir?.setOnClickListener {
            partir()
        }


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.tablayout?.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                val index = tab!!.position

                if(index == 0) {
                    val action = FirstFragmentDirections.actionFirstFragmentToVideoFragment()
                    findNavController().navigate(action)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val index = tab!!.position

                if(index == 0) {
                    val action = FirstFragmentDirections.actionFirstFragmentToVideoFragment()
                    findNavController().navigate(action)
                }
            }

        })
    }

    private fun valider() {



        val voyage = Voyage(
            LocalDate.parse(main_first_date.text.toString(), DateTimeFormatter.ISO_LOCAL_DATE),
            main_first_depart_location.text.toString(),
            Integer.parseInt(main_first_depart_km.text.toString()),
            main_first_arrivee_location.text.toString(),
            Integer.parseInt(main_first_arrivee_km.text.toString())
        )

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(voyage)
        findNavController().navigate(action)

    }

    private fun partir() {

        val binding = DataBindingUtil.inflate<FragmentFirstScene2Binding>(
            layoutInflater,
            R.layout.fragment_first_scene2,
            main_first_racine,
            false
        )
        binding.lifecycleOwner = this
        binding.setVariable(mainViewModele, mViewModele)
        binding.executePendingBindings();

        val loadedScene = Scene(main_first_layout, binding.root)
        val transition = TransitionInflater.from(context).inflateTransition(R.transition.transition)

        TransitionManager.go(loadedScene, transition)

        val btn = view?.findViewById<Button>(R.id.main_first_button)
        btn?.setOnClickListener {
            valider()
        }
    }
}
