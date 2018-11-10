package io.navendra.dayvr.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.navendra.dayvr.views.DayGL.DayGLSurfaceView

class DayGLFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DayGLSurfaceView(activity!!.applicationContext)
    }
}