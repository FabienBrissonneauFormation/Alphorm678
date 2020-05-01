package biz.ei6.projetfr678

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_capture.*

/**
 * A simple [Fragment] subclass.
 */
class CaptureFragment : Fragment() {

    val CODE_CAPTURE_OK = 42

    val TAG= "CAPTURE"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            capture_btn?.setOnClickListener { captureVideo() }
        }
    }

    fun captureVideo() {
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(intent, CODE_CAPTURE_OK)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, payLoad: Intent?) {

        if(requestCode == CODE_CAPTURE_OK) {
            if(resultCode == RESULT_OK) {
                Log.d(TAG, payLoad?.data.toString())
            }
        } else
        super.onActivityResult(requestCode, resultCode, payLoad)


    }
}
