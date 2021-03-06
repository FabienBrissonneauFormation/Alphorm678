package biz.ei6.projetfr678

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "FR678MAIN"

    lateinit var mViewModel : MainViewModele

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            nav_host_fragment.findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        Log.d(TAG,"oncreate")


        tablayout.addTab(tablayout.newTab().apply {setIcon(R.drawable.ic_video_view)})
        tablayout.addTab(tablayout.newTab().apply {setIcon(R.drawable.ic_video_record)})
        tablayout.addTab(tablayout.newTab().apply {setIcon(android.R.drawable.ic_dialog_map)})



        mViewModel = ViewModelProviders.of(this).get(MainViewModele::class.java)

        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FREEFORM_WINDOW_MANAGEMENT)) {
            Log.d(TAG,"Freeform est supporté")
        }


        Log.d(TAG, intent.action ?: "pas d'action")
        Log.d(TAG, intent.dataString ?: "pas de data")

        Log.d(TAG, intent.data?.lastPathSegment ?: " pas de last segment")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {

                val intent = Intent(this, SettingsActivity::class.java).apply { addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) }

                startActivity(intent)
                 return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onstart")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onresume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onrestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onstop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ondestroy")
    }

    override  fun onSaveInstanceState(outState : Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override  fun onRestoreInstanceState(outState : Bundle) {
        super.onRestoreInstanceState(outState)
        Log.d(TAG, "onRestoreInstanceState")
    }

}
