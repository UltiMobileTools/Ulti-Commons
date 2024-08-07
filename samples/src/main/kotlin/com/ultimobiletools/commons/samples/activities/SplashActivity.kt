package com.ultimobiletools.commons.samples.activities

import android.animation.Animator
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.hisavana.common.bean.TAdErrorCode
import com.hisavana.common.bean.TAdRequestBody.AdRequestBodyBuild
import com.hisavana.common.interfacz.OnSkipListener
import com.hisavana.common.interfacz.TAdListener
import com.ultimobiletools.commons.activities.BaseHisavnaSplashActivity
import com.ultimobiletools.commons.admob.AdsConstant
import com.ultimobiletools.commons.hisavana.AdManager
import com.ultimobiletools.commons.hisavana.AdManagerInterface
import com.ultimobiletools.commons.hisavana.TAdsConstant
import com.ultimobiletools.commons.samples.R


class SplashActivity : BaseHisavnaSplashActivity(), OnSkipListener, AdManagerInterface {
    val LOG_TAG: String = "SplashActivity"

    override fun backgroundColor(): Int {
        return resources.getColor(com.ultimobiletools.commons.R.color.md_grey_white);
    }

    override fun animation(): Int {
        return R.raw.res_splash_ani;
    }

    override fun initActivity() {

    }

    override fun initData() {
        AdManager(this).init(this, true, true, this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onAnimationEnd(p0: Animator) {
        System.currentTimeMillis();
    }

    override fun onAnimationRepeat(p0: Animator) {

    }

    override fun onClick() {
        goActivity()
    }

    override fun onTimeReach() {
    }


    fun goActivity() {
        startActivity(
            Intent(
                this, MainActivity::class.java
            )
        )
        finish()
    }

    override fun onCloudComplete() {
        tSplashAd!!.setRequestBody(
            AdRequestBodyBuild().setAdListener(object : TAdListener() {
                override fun onError(p0: TAdErrorCode?) {
                    Log.d(LOG_TAG, "onError:$p0")
                    goActivity()
                }

                override fun onShow(p0: Int) {
                    Log.d(LOG_TAG, "onShow:$p0")
                    tSplashAd!!.showAd(tSplashView!!);
                }

                override fun onClicked(p0: Int) {
                    Log.d(LOG_TAG, "onClicked:$p0")
                }

                override fun onClosed(p0: Int) {
                    Log.d(LOG_TAG, "onClicked:$p0")
                    goActivity()
                }

            }).build()
        )
        tSplashAd!!.setOnSkipListener(this)
        tSplashAd!!.loadAd();
    }

}
