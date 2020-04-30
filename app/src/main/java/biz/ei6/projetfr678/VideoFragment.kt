package biz.ei6.projetfr678

import android.app.PictureInPictureParams
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.fragment_video.view.*
import java.io.BufferedInputStream
import java.util.*
import java.util.jar.Manifest


class VideoFragment : Fragment() {

    val TAG = "VIDEO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)


        view.video_pic?.setOnClickListener { entrerEnModePicInPic() }

        return view

    }

fun entrerEnModePicInPic() {
    val ratio = Rational(video_view.width, video_view.height)
    val params = PictureInPictureParams.Builder()
        .setAspectRatio(ratio)
        .build()

    video_pic.visibility = View.INVISIBLE


    video_view.setMediaController(null)

    requireActivity().enterPictureInPictureMode(params)

}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( ! requireActivity().isInPictureInPictureMode) lanceChargementDesDonnees()
    }

    val CODE_OUVERTURE_DOC = 42
    private fun lanceChargementDesDonnees() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type="video/mp4"
        }
        startActivityForResult( intent,CODE_OUVERTURE_DOC)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, payload: Intent?) {
        if (requestCode == CODE_OUVERTURE_DOC) {
            if (resultCode == AppCompatActivity.RESULT_OK) {



                video_view.setVideoURI(payload?.data!!)

                val mc = MediaController(requireContext())
                mc.setAnchorView(video_view)
                video_view.setMediaController(mc)

                video_view.setOnPreparedListener { mp -> Log.d(TAG,"Durée de la vidéo : ${video_view.duration}") }
                video_view.start()


                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Impossible d'ouvrir le document",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

}
