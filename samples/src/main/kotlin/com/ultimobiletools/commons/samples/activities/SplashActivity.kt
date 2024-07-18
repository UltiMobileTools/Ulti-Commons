package com.ultimobiletools.commons.samples.activities

import android.animation.Animator
import android.content.Intent
import com.ultimobiletools.commons.activities.BaseSplashActivity
import com.ultimobiletools.commons.samples.R

class SplashActivity : BaseSplashActivity() {
    override fun backgroundColor(): Int {
        return resources.getColor(com.ultimobiletools.commons.R.color.md_grey_white);
    }

    override fun animation(): Int {
        return R.raw.res_splash_ani;
    }

    override fun initActivity() {
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
    }

    override fun initData() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onAnimationEnd(p0: Animator) {
        System.currentTimeMillis();
    }

    override fun onAnimationRepeat(p0: Animator) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
