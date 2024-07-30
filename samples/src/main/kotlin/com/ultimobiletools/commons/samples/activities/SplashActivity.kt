package com.ultimobiletools.commons.samples.activities

import android.animation.Animator
import android.content.Intent
import com.ultimobiletools.commons.activities.BaseAdActivity
import com.ultimobiletools.commons.activities.BaseSplashActivity
import com.ultimobiletools.commons.samples.R

class SplashActivity : BaseAdActivity() {
    override fun goActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }



}
