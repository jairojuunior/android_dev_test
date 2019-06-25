package br.edu.ufabc.padm.contentadaptation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class DynamicFragmentsActivity : AppCompatActivity() {

    companion object {
        private val LOGTAG = DynamicFragmentsActivity::class.java.getSimpleName() + " TRACEFRAGMENTS"
    }

    private lateinit var topTrigger: Button
    private lateinit var bottomTrigger: Button
    private lateinit var fragmentTop: StaticFragmentTop
    private lateinit var fragmentBottom: StaticFragmentBottom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragments)
        init()
        bindHandlers()
        Log.d(LOGTAG, "onCreate")
    }

    private fun init() {
        topTrigger = findViewById(R.id.top_trigger)
        bottomTrigger = findViewById(R.id.bottom_trigger)
        fragmentTop = StaticFragmentTop()
        fragmentBottom = StaticFragmentBottom()
    }

    private fun bindHandlers() {
        topTrigger.setOnClickListener {
            Log.d(LOGTAG, "Top button clicked")
            val transaction = supportFragmentManager.beginTransaction()

            transaction.add(R.id.top_container, fragmentTop)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.addToBackStack(null)
            transaction.commit()
            topTrigger.isEnabled = false
        }
        bottomTrigger.setOnClickListener {
            Log.d(LOGTAG, "Bottom button clicked")
            val transaction = supportFragmentManager.beginTransaction()

            transaction.add(R.id.bottom_container, fragmentBottom)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.addToBackStack(null)
            transaction.commit()
            bottomTrigger.isEnabled = false
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            super.onBackPressed()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOGTAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOGTAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOGTAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOGTAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOGTAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOGTAG, "onRestart")
    }
}
