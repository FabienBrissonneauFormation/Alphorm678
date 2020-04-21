package biz.ei6.projetfr678

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TraditionFragmentActivity : AppCompatActivity(), BlankFragment.BlankFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tradition_fragment)

        val frag = BlankFragment(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentactivity_contenu,frag)
            .commit()
    }

    override fun next() {
        val frag = FirstFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentactivity_contenu,frag)
            .commit()
    }
}
