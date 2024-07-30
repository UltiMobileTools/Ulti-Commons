package com.ultimobiletools.commons.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.initialization.InitializationStatus
import com.ultimobiletools.commons.admob.AdsConstant
import com.ultimobiletools.commons.admob.GoogleMobileAdsConsentManager
import com.ultimobiletools.commons.admob.open.AdManager
import com.ultimobiletools.commons.admob.open.AppOpenAdManager
import java.util.Arrays

abstract class BaseAdActivity : ComponentActivity(), AdManager {
    private lateinit var googleMobileAdsConsentManager: GoogleMobileAdsConsentManager
    val LOG_TAG: String = "BaseAdActivity"

    abstract fun goActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        googleMobileAdsConsentManager = GoogleMobileAdsConsentManager.getInstance(applicationContext)
        googleMobileAdsConsentManager.gatherConsent(this) { consentError ->
            if (consentError != null) {
                // Consent not obtained in current session.
                Log.w(LOG_TAG, String.format("%s: %s", consentError.errorCode, consentError.message))
            }

            if (googleMobileAdsConsentManager.canRequestAds) {
                initializeMobileAdsSdk()
            }
        }

        // This sample attempts to load ads using consent obtained in the previous session.
        if (googleMobileAdsConsentManager.canRequestAds) {
            initializeMobileAdsSdk()
        }
    }

    private fun initializeMobileAdsSdk() {
        // Set your test devices.
        MobileAds.setRequestConfiguration(RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList<String>(AdsConstant.TEST_DEVICE_HASHED_ID)).build())
        Thread {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(
                this
            ) { initializationStatus: InitializationStatus? -> }
            // Load an ad on the main thread.
            runOnUiThread {
                AppOpenAdManager().loadAd(this, this)
            }
        }.start()
    }

    override fun onAdLoaded() {
        Log.w(LOG_TAG, "onAdLoaded")
        AppOpenAdManager().showAdIfAvailable(this@BaseAdActivity, this)
    }

    override fun onLoadAdFail() {
        Log.w(LOG_TAG, "onLoadAdFail")
        goActivity()
    }

    override fun onAdDismissedFull() {
        Log.w(LOG_TAG, "onAdDismissedFull")
        goActivity()
    }

    override fun onAdFailedToShowFull() {
        Log.w(LOG_TAG, "onAdFailedToShowFull")
        goActivity()
    }

}
