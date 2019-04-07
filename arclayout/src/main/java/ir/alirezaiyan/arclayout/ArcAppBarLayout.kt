package ir.alirezaiyan.arclayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import ir.alirezaiyan.arclayout.utils.ArcLayoutSettings

class ArcAppBarLayout : AppBarLayout {

    private lateinit var settings: ArcLayoutSettings

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        settings = ArcLayoutSettings(context, attrs)
        settings.elevation = ViewCompat.getElevation(this)
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

    override fun dispatchDraw(canvas: Canvas) {

        for (aClipPath in createClipPath())
            canvas.clipPath(aClipPath)

        super.dispatchDraw(canvas)

    }
}
