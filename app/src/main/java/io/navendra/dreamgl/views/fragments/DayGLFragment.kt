package io.navendra.dreamgl.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.navendra.dreamgl.views.DayGL.DayGLSurfaceView

class DayGLFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DayGLSurfaceView(activity!!.applicationContext)
    }
}