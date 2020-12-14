package com.tck.my.view.path

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import androidx.core.graphics.toColorInt
import kotlin.math.tan

/**
 *<p>description:</p>
 *<p>created on: 2020/12/14 9:46</p>
 * @author tck
 *
 */
class TriangleRoundView : View {

    private val bgPaint: Paint
    private val bgPath: Path = Path()
    private var size71 = 0f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {

        bgPaint = Paint().apply {
            isAntiAlias = true
            color = "#fffdeee9".toColorInt()
        }

        size71 = 71f.dp2pxFloat()


        clipToOutline = true
        outlineProvider = MyViewOutlineProvider()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        bgPath.reset()
//
//        bgPath.lineTo(0f, 0f)
//        bgPath.lineTo(0f, size71)
//        bgPath.lineTo(width.toFloat(), (size71 - width / tan(Math.toRadians(75.0))).toFloat())
//        bgPath.lineTo(width.toFloat(), 0f)
//        bgPath.close()
//        canvas?.drawPath(bgPath, bgPaint)

    }
}

fun Float.dp2px(): Int = (Resources.getSystem().displayMetrics.density * this + 0.5f).toInt()

class MyViewOutlineProvider(var radius: Int = 10f.dp2px()) : ViewOutlineProvider() {

    override fun getOutline(view: View?, outline: Outline?) {
        view?.let {
            outline?.setRoundRect(0, 0, it.width, it.height, radius.toFloat())
        }
    }

}

fun Float.dp2pxFloat(): Float = (Resources.getSystem().displayMetrics.density * this + 0.5f)