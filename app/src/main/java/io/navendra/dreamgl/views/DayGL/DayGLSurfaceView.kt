package io.navendra.dreamgl.views.DayGL

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class DayGLSurfaceView @JvmOverloads constructor(context: Context,
    attributeSet: AttributeSet? = null) : GLSurfaceView(context,attributeSet){

    private val renderer : DayGLRenderer

    init {
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2)
        renderer = DayGLRenderer()
        setRenderer(renderer)
        renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
    }

}