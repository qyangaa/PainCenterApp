package com.example.paincenterapp.ui.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GestureDetectorCompat
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.example.paincenterapp.R


class PinView @JvmOverloads constructor(context: Context?, attr: AttributeSet? = null) :
    SubsamplingScaleImageView(context, attr) {
    private val paint = Paint()
    private val vPin = PointF()
    private var sPin: PointF? = null
    private var pin: Bitmap? = null
    private var pinViewGestureListener = PinViewGestureListener()
    private var mGestureDetector: GestureDetectorCompat? = null
    fun setPin(sPin: PointF?) {
        this.sPin = sPin
        initialize()
        invalidate()
    }

    private fun initialize() {
        mGestureDetector = GestureDetectorCompat(context, pinViewGestureListener)


        val density = resources.displayMetrics.densityDpi.toFloat()
        val pinDrawable =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_test_24, null)
        pin = ImgUtils.drawableToBitmap(pinDrawable!!)
        val w = density / 420f * pin!!.getWidth()
        val h = density / 420f * pin!!.getHeight()
        pin = Bitmap.createScaledBitmap(pin!!, w.toInt(), h.toInt(), true)

    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        mGestureDetector?.onTouchEvent(event);
//        // Handle any other event here, if not long press.
//        return true
//    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady) {
            return
        }
        paint.isAntiAlias = true
        if (sPin != null && pin != null) {
            sourceToViewCoord(sPin, vPin)
            val vX = vPin.x - pin!!.width / 2
            val vY = vPin.y - pin!!.height
            canvas.drawBitmap(pin!!, vX, vY, paint)
        }
    }

    init {
        initialize()
    }
}