package com.mobiledev.appkotlin.ui.picture

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PictureViewModel : View {

    val mutableList = mutableListOf<MagicCircle>()

    //constructeurs secondaires
    constructor(context: Context) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    //fonction native onDraw
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (mCircle in mutableList) {
            mCircle.move()
            canvas?.drawCircle(mCircle.cx, mCircle.cy, mCircle.rad, mCircle.mPaint)
            invalidate()
        }
    }

    //fonction native onLayout
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bot: Int) {
        super.onLayout(changed, left, top, right, bot)
        mCircle = MagicCircle(width, height, 50F, 50F)
        mutableList.add(mCircle)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> mutableList.add(MagicCircle(width, height, event.x, event.y))
            MotionEvent.ACTION_MOVE -> {
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return true
    }
}