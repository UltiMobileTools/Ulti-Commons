package com.ultimobiletools.commons.activities

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.snackbar.BaseTransientBottomBar.AnimationMode
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.extensions.*
import com.ultimobiletools.commons.helpers.SIDELOADING_TRUE
import com.ultimobiletools.commons.helpers.SIDELOADING_UNCHECKED

abstract class BaseSplashActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var lottieView: LottieAnimationView? = null

    abstract fun backgroundColor(): Int;

    abstract fun animation(): Int;

    abstract fun initActivity()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        lottieView?.cancelAnimation()
    }

    fun setView() {
        lottieView = findViewById(R.id.lottieView)
        lottieView?.setBackgroundColor(backgroundColor())
        lottieView?.setAnimation(animation())
        lottieView?.playAnimation()
        lottieView?.addAnimatorListener(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setView()
        initData()
        if (baseConfig.appSideloadingStatus == SIDELOADING_UNCHECKED) {
            if (checkAppSideloading()) {
                return
            }
        } else if (baseConfig.appSideloadingStatus == SIDELOADING_TRUE) {
            showSideloadingDialog()
            return
        }

        baseConfig.apply {
            if (isUsingAutoTheme) {
                val isUsingSystemDarkTheme = isUsingSystemDarkTheme()
                isUsingSharedTheme = false
                textColor = resources.getColor(if (isUsingSystemDarkTheme) R.color.theme_dark_text_color else R.color.theme_light_text_color)
                backgroundColor = resources.getColor(if (isUsingSystemDarkTheme) R.color.theme_dark_background_color else R.color.theme_light_background_color)
            }
        }

        if (!baseConfig.isUsingAutoTheme && !baseConfig.isUsingSystemTheme && isThankYouInstalled()) {
            getSharedTheme {
                if (it != null) {
                    baseConfig.apply {
                        wasSharedThemeForced = true
                        isUsingSharedTheme = true
                        wasSharedThemeEverActivated = true

                        textColor = it.textColor
                        backgroundColor = it.backgroundColor
                        primaryColor = it.primaryColor
                        accentColor = it.accentColor
                    }

                    if (baseConfig.appIconColor != it.appIconColor) {
                        baseConfig.appIconColor = it.appIconColor
                        checkAppIconColor()
                    }
                }
                initActivity()
            }
        } else {
            initActivity()
        }
    }

    override fun onAnimationStart(p0: Animator) {
    }

    override fun onAnimationEnd(p0: Animator) {
    }

    override fun onAnimationCancel(p0: Animator) {
    }

    override fun onAnimationRepeat(p0: Animator) {
    }
}
