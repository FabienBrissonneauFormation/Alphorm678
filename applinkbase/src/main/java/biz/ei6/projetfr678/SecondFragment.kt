package biz.ei6.projetfr678

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.activityViewModels

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val TAG = "SecondFragment"

    val mViewModele : MainViewModele by activityViewModels<MainViewModele>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)

        fab?.setOnClickListener { view ->
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val args = navArgs<SecondFragmentArgs>()
        val voyage = args.value.voyage
        Log.d(TAG, voyage.toString())

        mViewModele.voyages.value!!.add(voyage)

        main_second_voyagesliste.adapter = VoyagesAdapter(requireContext(), mViewModele.voyages.value!!)
        main_second_voyagesliste.layoutManager = LinearLayoutManager(context)

      /*  val resultObserver = object :  Observer<Int> {
            override fun onChanged(t: Int?) {
                textview_second.append(t.toString())
            }
        }

        mViewModele.kilometres.observe(viewLifecycleOwner,resultObserver)*/
    }
}
