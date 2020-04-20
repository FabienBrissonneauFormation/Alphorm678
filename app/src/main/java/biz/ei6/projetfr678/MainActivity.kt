package biz.ei6.projetfr678

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "FR678MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        Log.d(TAG,"oncreate")
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
            R.id.action_settings -> true
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
