package com.example.fabexplosionanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.fabexplosionanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root )

        initAnimation()

    }

    private fun initAnimation() = with(binding) {
        val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.circle_explosion_anim).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        fab.setOnClickListener {
            fab.isVisible = false
            circle.isVisible = true
            circle.startAnimation(animation) {
                // display anything
                root.setBackgroundColor(ContextCompat.getColor(it.context, R.color.purple_500))
                circle.isVisible = false
            }
        }

    }

}
