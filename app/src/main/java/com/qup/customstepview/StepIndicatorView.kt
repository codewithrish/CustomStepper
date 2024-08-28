package com.qup.customstepview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout

class StepIndicatorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onClick: ((Int) -> Unit)? = null

    init {
        orientation = HORIZONTAL
        inflate(context, R.layout.view_step_indicator, this)

        for (i in 0 until childCount) {
            if (i%2 == 0) {
                val stepView = getChildAt(i)
                stepView.setOnClickListener {
                    onClick?.invoke(i)
                }
            }
        }
    }

    fun setStep(step: Int) {
        val totalSteps = childCount / 2 + 1
        for (i in 0 until totalSteps) {
            val stepView = getChildAt(i * 2)
            stepView.isSelected = (i == step)
        }
    }
}