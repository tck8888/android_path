package com.tck.my.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import kotlin.math.tan

/**
 *<p>description:</p>
 *<p>created on: 2020/12/14 9:46</p>
 * @author tck
 *
 */
class TrapezoidView : View {

    private val paint: Paint
    private val path: Path


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        paint = Paint().apply {
            isAntiAlias = true
            color = "#ffed5824".toColorInt()
        }

        path = Path()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        path.moveTo(0f, 0f)
        path.lineTo(0f, height.toFloat())
        path.lineTo(width.toFloat(), (height.toFloat()-width/ tan(Math.toRadians(85.0))).toFloat())
        path.lineTo(width.toFloat(), 0f)
        path.close()
        canvas?.drawPath(path, paint)
    }
}