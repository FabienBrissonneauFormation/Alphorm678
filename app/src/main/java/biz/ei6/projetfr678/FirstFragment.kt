package biz.ei6.projetfr678

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import biz.ei6.projetfr678.databinding.FragmentFirstBinding
import biz.ei6.projetfr678.BR.mainViewModele
import biz.ei6.projetfr678.databinding.FragmentFirstScene1Binding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.main_first_date
import kotlinx.android.synthetic.main.fragment_first.main_first_depart_km
import kotlinx.android.synthetic.main.fragment_first.main_first_depart_location
import kotlinx.android.synthetic.main.fragment_first_scene1.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val mViewModele: MainViewModele by activityViewModels<MainViewModele>()

    lateinit var binding: FragmentFirstScene1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentFirstScene1Binding>(
            inflater,
            R.layout.fragment_first_scene1,
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        binding.setVariable(mainViewModele, mViewModele)

        val obs = FragmentObservateur()
        lifecycle.addObserver(obs)

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
        val set = ConstraintSet()

        val bds = ChangeBounds()
        bds.duration = 3000
        bds.interpolator = AnticipateOvershootInterpolator() //BounceInterpolator()

        TransitionManager.beginDelayedTransition(main_first_layout,bds)


        set.connect(
            R.id.main_first_depart_location,
            ConstraintSet.START,
            R.id.main_first_depart_km,
            ConstraintSet.END,
            10
        )
        set.connect(
            R.id.main_first_depart_location,
            ConstraintSet.TOP,
            R.id.main_first_depart_km,
            ConstraintSet.TOP,
            10
        )
        set.connect(
            R.id.main_first_depart_location,
            ConstraintSet.BOTTOM,
            R.id.main_first_depart_km,
            ConstraintSet.BOTTOM,
            10
        )

        set.constrainWidth(R.id.main_first_depart_location, ConstraintSet.WRAP_CONTENT)
        set.constrainHeight(R.id.main_first_depart_location, ConstraintSet.WRAP_CONTENT)

        set.setVisibility(R.id.main_first_partir, ConstraintSet.INVISIBLE)

        set.applyTo(main_first_layout)
    }
}
