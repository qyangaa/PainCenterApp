package com.example.paincenterapp.ui.utils

import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.MotionEventCompat

class LongPressGestureListener : GestureDetector.SimpleOnGestureListener() {
    override fun onLongPress(e: MotionEvent) {
        super.onLongPress(e)
        // e will give you the location and everything else you want
        // This is where you will be doing whatever you want to.
        val eIndex = MotionEventCompat.getActionIndex(e)
        val eX = MotionEventCompat.getX(e, eIndex)
        val eY = MotionEventCompat.getY(e, eIndex)
    }

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }
}