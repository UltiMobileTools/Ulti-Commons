package com.ultimobiletools.commons.samples.activities

import android.animation.Animator
import android.content.Intent
import com.airbnb.lottie.LottieAnimationView
import com.ultimobiletools.commons.activities.BaseSplashActivity
import com.ultimobiletools.commons.samples.R

class SplashActivity : BaseSplashActivity(), Animator.AnimatorListener {
    val LOG_TAG: String = "SplashActivity"
    private var lottieView: LottieAnimationView? = null

    override fun setContentView(): Int {
        return R.layout.activity_splash
    }

    override fun initActivity() {

    }

    override fun initData() {

    }

    override fun intView() {
        lottieView = findViewById(R.id.lottieView)
        lottieView?.setBackgroundColor(resources.getColor(com.ultimobiletools.commons.R.color.md_grey_white))
        lottieView?.setAnimation(R.raw.res_splash_ani)
        lottieView?.playAnimation()
        lottieView?.addAnimatorListener(this)
    }

    private fun goActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        lottieView?.cancelAnimation()
    }

    override fun onAnimationStart(p0: Animator) {
    }

    override fun onAnimationEnd(p0: Animator) {
    }

    override fun onAnimationCancel(p0: Animator) {
    }

    override fun onAnimationRepeat(p0: Animator) {
        goActivity()
    }
}
