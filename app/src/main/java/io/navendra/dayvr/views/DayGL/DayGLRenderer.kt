package io.navendra.dayvr.views.DayGL

import android.graphics.Color
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import io.navendra.dayvr.views.DayGL.shapes.DayGLSquare
import io.navendra.dayvr.views.DayGL.shapes.DayGLTriangle
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class DayGLRenderer: GLSurfaceView.Renderer{

    // number of coordinates per vertex in this array
    val COORDS_PER_VERTEX = 3
    var triangleCoords = floatArrayOf(     // in counterclockwise order:
        0.0f, 0.622008459f, 0.0f,      // top
        -0.5f, -0.311004243f, 0.0f,    // bottom left
        0.5f, -0.311004243f, 0.0f      // bottom right
    )

    var squareCoords = floatArrayOf(
        -0.5f,  0.5f, 0.0f,      // top left
        -0.5f, -0.5f, 0.0f,      // bottom left
        0.5f, -0.5f, 0.0f,      // bottom right
        0.5f,  0.5f, 0.0f       // top right
    )


    private lateinit var triangle : DayGLTriangle
    private lateinit var square: DayGLSquare

    override fun onDrawFrame(gl: GL10?) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
        triangle.draw()
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        setBackgroundColor(Color.RED)
        triangle = DayGLTriangle(triangleCoords,COORDS_PER_VERTEX)
        square = DayGLSquare(squareCoords,COORDS_PER_VERTEX)

    }



    //region Utils
    private fun setBackgroundColor(color: Int){
        val col_A = (color shr 24 and 0xff).toFloat()
        val col_R = (color shr 16 and 0xff).toFloat()
        val col_G = (color shr 8 and 0xff).toFloat()
        val col_B = (color and 0xff).toFloat()

        GLES20.glClearColor(col_R,col_G,col_B,col_A)
//        GLES20.glClearColor(0.0F,0.0F,0.0F,0.0F)
    }
    //endregion

}