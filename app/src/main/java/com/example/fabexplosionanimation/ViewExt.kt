package com.example.fabexplosionanimation

import android.view.View
import android.view.animation.Animation

fun View.startAnimation(
    animation: Animation,
    onEnded: () -> Unit
) {
    animation.setAnimationListener(object: Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) = Unit

        override fun onAnimationEnd(p0: Animation?) {
            onEnded()
        }

        override fun onAnimationRepeat(p0: Animation?) = Unit
    })

    this.startAnimation(animation)
}
