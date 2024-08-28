package com.qup.customstepview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout

class StepIndicatorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = HORIZONTAL
        inflate(context, R.layout.view_step_indicator, this)
    }

    fun setStep(step: Int) {
        val totalSteps = childCount / 2 + 1 // Directly use childCount now

        Log.d("TAG", "Current step: $step, Total steps: $totalSteps")

        for (i in 0 until totalSteps) {
            val stepView = getChildAt(i * 2)
            stepView.isSelected = (i == step)
            Log.d("TAG", "Step $i isSelected: ${stepView.isSelected}")
        }
    }
}