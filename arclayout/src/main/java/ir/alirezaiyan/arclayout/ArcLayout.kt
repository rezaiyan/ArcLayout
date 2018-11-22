package ir.alirezaiyan.arclayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider

class ArcLayout : AppBarLayout {

    lateinit var settings: ArcLayoutSettings

    private lateinit var clipPath: Array<Path>

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        settings = ArcLayoutSettings(context, attrs)
        settings.elevation = ViewCompat.getElevation(this)

        /**
         * If hardware acceleration is on (default from API 14), clipPath worked correctly
         * from API 18.
         *
         * So we will disable hardware Acceleration if API < 18
         *
         * https://developer.android.com/guide/topics/graphics/hardware-accel.html#unsupported
         * Section #Unsupported Drawing Operations
         */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
    }

    private fun createClipPath(): Array<Path> {

        val topPath = Path()
        val bottomPath = Path()

        if (!settings.isDirectionBottom)
            clipNoting(topPath)
        else
            clipBottomArc(topPath)

        if (!settings.isDirectionTop)
            clipNoting(bottomPath)
        else
            clipTopArc(bottomPath)

        return arrayOf(topPath, bottomPath)
    }

    private fun clipTopArc(path: Path) {
        val topArcHeight = settings.topArcHeight

        path.moveTo(0f, topArcHeight)
        path.lineTo(0f, height.toFloat())
        path.lineTo(width.toFloat(), height.toFloat())
        path.lineTo(width.toFloat(), topArcHeight)

        if (settings.isTopCropConvex) {
            path.quadTo((width / 2).toFloat(), -1 * topArcHeight, 0f, topArcHeight)
        } else {
            path.quadTo((width / 2).toFloat(), 2 * topArcHeight, 0f, topArcHeight)
        }

    }

    private fun clipNoting(path: Path) {
        path.moveTo(0f, 0f)
        path.lineTo(0f, height.toFloat())
        path.lineTo(width.toFloat(), height.toFloat())
        path.lineTo(width.toFloat(), 0f)
    }

    private fun clipBottomArc(path: Path) {
        val bottomArcHeight = settings.bottomArcHeight
        path.moveTo(0f, 0f)
        path.lineTo(0f, height - bottomArcHeight)
        if (settings.isBottomCropConvex) {
            path.quadTo((width / 2).toFloat(), height + bottomArcHeight, width.toFloat(), height - bottomArcHeight)
        } else {
            path.quadTo((width / 2).toFloat(), height - 2 * bottomArcHeight, width.toFloat(), height - bottomArcHeight)
        }
        path.lineTo(width.toFloat(), 0f)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d(TAG, "onLayout() called with: changed = [$changed], left = [$left], top = [$top], right = [$right], bottom = [$bottom]")
        if (changed) {
            calculateLayout()
        }
    }

    private fun calculateLayout() {
        val height = measuredHeight
        val width = measuredWidth
        if (width > 0 && height > 0) {

            clipPath = createClipPath()
            ViewCompat.setElevation(this, settings.elevation)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && settings.isTopCropConvex && settings.isBottomCropConvex) {
                ViewCompat.setElevation(this, settings.elevation)
                outlineProvider = object : ViewOutlineProvider() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    override fun getOutline(view: View, outline: Outline) {
                        for (aClipPath in clipPath)
                            outline.setConvexPath(aClipPath)
                    }
                }
            }
        }
    }


    override fun dispatchDraw(canvas: Canvas) {
        Log.d(TAG, "dispatchDraw() called with: canvas = [$canvas]")
        canvas.save()

        for (aClipPath in clipPath) {
            canvas.clipPath(aClipPath)
        }
        super.dispatchDraw(canvas)

        canvas.restore()
    }

    companion object {
        private val TAG = "ArcLayout"
    }
}
