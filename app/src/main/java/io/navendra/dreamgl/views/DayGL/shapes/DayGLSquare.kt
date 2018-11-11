package io.navendra.dreamgl.views.DayGL.shapes

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer

class DayGLSquare(private val squareCoords: FloatArray, private val COORDS_PER_VERTEX: Int = 3){
    private val drawOrder = shortArrayOf(0,1,2,0,2,3)

    private val vertexBuffer : FloatBuffer =
            ByteBuffer.allocateDirect(squareCoords.size*4).run {
                order(ByteOrder.nativeOrder())
                asFloatBuffer().apply {
                    put(squareCoords)
                    position(0)
                }
            }

    private val drawListBuffer: ShortBuffer =
            ByteBuffer.allocateDirect(drawOrder.size* 2).run {
                order(ByteOrder.nativeOrder())
                asShortBuffer().apply {
                    put(drawOrder)
                    position(0)
                }
            }
}