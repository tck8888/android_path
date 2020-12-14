package com.tck.my.view.path

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 *<p>description:</p>
 *<p>created on: 2020/10/17 10:51</p>
 * @author tck
 * @version v1.3.0
 *
 */
class RoundCornerFrameLayout : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
            context,
            attributeSet,
            defStyle
    ) {

        clipToOutline = true
        outlineProvider = MyViewOutlineProvider()
    }
}
