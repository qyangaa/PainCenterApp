package com.example.paincenterapp.ui.utils

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.core.view.MotionEventCompat

class PinViewGestureListener : GestureDetector.SimpleOnGestureListener(), View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener {
    private var view: View? = null
    private val gestureScale: ScaleGestureDetector? = null
    private var scaleFactor = 1f
    private var inScale = false

    override fun onLongPress(e: MotionEvent) {
        super.onLongPress(e)
        // e will give you the location and everything else you want
        // This is where you will be doing whatever you want to.
        val eIndex = MotionEventCompat.getActionIndex(e)
        val eX = MotionEventCompat.getX(e, eIndex)
        val eY = MotionEventCompat.getY(e, eIndex)
        Log.d("X:Y = ", "${eX}, ${eY}")
    }



    override fun onDown(e: MotionEvent): Boolean {
        Log.d("XXX PinViewGesture", "onDown")
        return false
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        Log.d("XXX PinViewGesture", "onTouch")
        this.view = p0
        gestureScale?.onTouchEvent(p1)
        return false
    }

    override fun onScale(p0: ScaleGestureDetector): Boolean {
        scaleFactor *= p0.scaleFactor
        scaleFactor =
            if (scaleFactor < 1) 1F else scaleFactor // prevent our view from becoming too small //

        scaleFactor =
            ((scaleFactor * 100) as Int).toFloat() / 100 // Change precision to help with jitter when user just rests their fingers //

        this.view?.scaleX = scaleFactor
        this.view?.scaleY = scaleFactor
        return true
    }

    override fun onScaleBegin(p0: ScaleGestureDetector?): Boolean {
        inScale = true;
        return true;
    }

    override fun onScaleEnd(p0: ScaleGestureDetector?) {
        inScale = false;
    }
}