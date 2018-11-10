package io.navendra.dayvr.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.navendra.dayvr.R
import io.navendra.dayvr.views.fragments.DayGLFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val glFragment = DayGLFragment()
        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(R.id.fragment_container,glFragment)
                addToBackStack(null)
                commit()
            }
        }

    }

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
