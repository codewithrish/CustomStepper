package com.qup.customstepview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViewPager()
    }

    private fun setupViewPager() {
        // In your Activity or Fragment
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val stepIndicator = findViewById<StepIndicatorView>(R.id.stepIndicator)

        viewPager.adapter = MyPagerAdapter(supportFragmentManager)
        stepIndicator.setStep(0)

        stepIndicator.onClick = {
            viewPager.currentItem = it/2
            stepIndicator.setStep(it/2)
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                stepIndicator.setStep(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}