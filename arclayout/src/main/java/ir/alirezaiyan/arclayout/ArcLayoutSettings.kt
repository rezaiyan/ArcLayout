package ir.alirezaiyan.arclayout

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue


class ArcLayoutSettings internal constructor(context: Context, attrs: AttributeSet?) {

    var isTopCropConvex = true
    var isBottomCropConvex = true
    var isDirectionBottom = true
    var isDirectionTop = false
    val bottomArcHeight: Float
    val topArcHeight: Float
    var elevation: Float = 0.toFloat()

    init {
        val styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ArcHeader, 0, 0)
        bottomArcHeight = styledAttributes.getDimension(R.styleable.ArcHeader_arc_bottom_height, dpToPx(context, DEFAULT_ARC_HEIGHT))
        topArcHeight = styledAttributes.getDimension(R.styleable.ArcHeader_arc_top_height, dpToPx(context, DEFAULT_ARC_HEIGHT))

        val topCropDirection = styledAttributes.getInt(R.styleable.ArcHeader_arc_top_cropCurve, CROP_CONVEX)
        isTopCropConvex = topCropDirection and CROP_CONVEX == CROP_CONVEX

        val bottomCropDirection = styledAttributes.getInt(R.styleable.ArcHeader_arc_bottom_cropCurve, CROP_CONVEX)
        isBottomCropConvex = bottomCropDirection and CROP_CONVEX == CROP_CONVEX

        val arcBottomPosition = styledAttributes.getInt(R.styleable.ArcHeader_arc_bottom_position, DIRECTION_BOTTOM)
        val arcTopPosition = styledAttributes.getInt(R.styleable.ArcHeader_arc_top_position, DIRECTION_TOP)
        isDirectionBottom = arcBottomPosition and DIRECTION_BOTTOM == DIRECTION_BOTTOM
        isDirectionTop = arcTopPosition and DIRECTION_TOP == DIRECTION_TOP

        styledAttributes.recycle()
    }

    companion object {
        private val TAG = "ArcLayoutSettings"

        val CROP_CONVEX = 1
        val CROP_CONCAVE = 2
        val DIRECTION_BOTTOM = 1
        val DIRECTION_TOP = 2

        private val DEFAULT_ARC_HEIGHT = 32

        private fun dpToPx(context: Context, dp: Int): Float {
            val r = context.resources
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics)
        }
    }
}
