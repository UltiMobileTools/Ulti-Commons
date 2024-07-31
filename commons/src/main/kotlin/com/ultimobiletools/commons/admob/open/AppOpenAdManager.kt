package com.ultimobiletools.commons.admob.open

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import com.ultimobiletools.commons.admob.AdsConstant
import com.ultimobiletools.commons.admob.AdsConstant.AD_OPEN_UNIT_ID
import com.ultimobiletools.commons.admob.GoogleMobileAdsConsentManager
import java.util.Date

class AppOpenAdManager {
    val LOG_TAG: String = "AppOpenAdManager"
    private var googleMobileAdsConsentManager: GoogleMobileAdsConsentManager? = null
    var appOpenAd: AppOpenAd? = null
//    var isLoadingAd: Boolean = false
//    var isShowingAd: Boolean = false
//    var loadTime: Long = 0
//
    fun AppOpenAdManager(context: Context?) {
        if (googleMobileAdsConsentManager == null) {
            googleMobileAdsConsentManager = GoogleMobileAdsConsentManager.getInstance(context!!)
        }
    }

    fun loadAd(context: Context?, loadAndShowAdCompleteListener: AdManager) {
        // Do not load ad if there is an unused ad or one is already loading.
//        if (isLoadingAd || isAdAvailable()) {
//            return
//        }

//        isLoadingAd = true
        val request = AdRequest.Builder().build()
        Log.d(LOG_TAG, "AD_OPEN_UNIT_ID:"+AdsConstant.AD_OPEN_UNIT_ID)
        AppOpenAd.load(context!!, AdsConstant.AD_OPEN_UNIT_ID, request, object : AppOpenAdLoadCallback() {
            /**
             * Called when an app open ad has loaded.
             *
             * @param ad the loaded app open ad.
             */

            override fun onAdLoaded(ad: AppOpenAd) {
                appOpenAd = ad
//                isLoadingAd = false
//                loadTime = Date().time
                Log.d(LOG_TAG, "onAdLoaded.")
//                Toast.makeText(context, "onAdLoaded", Toast.LENGTH_SHORT).show()
                loadAndShowAdCompleteListener.onAdLoaded()
            }

            /**
             * Called when an app open ad has failed to load.
             *
             * @param loadAdError the error.
             */
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
//                isLoadingAd = false
                Log.d(LOG_TAG, "onAdFailedToLoad: " + loadAdError.message)
//                Toast.makeText(context, "onAdFailedToLoad", Toast.LENGTH_SHORT).show()
                loadAndShowAdCompleteListener.onLoadAdFail()
            }
        })
    }


    /**
     * Check if ad exists and can be shown.
     */
//    private fun isAdAvailable(): Boolean {
//        // Ad references in the app open beta will time out after four hours, but this time limit
//        // may change in future beta versions. For details, see:
//        // https://support.google.com/admob/answer/9341964?hl=en
//        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4)
//    }

    /**
     * Check if ad was loaded more than n hours ago.
     */
//    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
//        val dateDifference = Date().time - loadTime
//        val numMilliSecondsPerHour: Long = 3600000
//        return (dateDifference < (numMilliSecondsPerHour * numHours))
//    }


    /**
     * Show the ad if one isn't already showing.
     *
     * @param activity the activity that shows the app open ad
     */
    fun showAdIfAvailable(activity: Activity, loadAndShowAdCompleteListener: AdManager) {
        // If the app open ad is already showing, do not show the ad again.
//        if (isShowingAd) {
//            Log.d(LOG_TAG, "The app open ad is already showing.")
//            return
//        }
        // If the app open ad is not available yet, invoke the callback then load the ad.
//        if (!isAdAvailable()) {
//            Log.d(LOG_TAG, "The app open ad is not ready yet.")
//            //            onShowAdComplete();
//            if (googleMobileAdsConsentManager!!.canRequestAds) {
//                loadAd(activity, loadAndShowAdCompleteListener)
//            }
//            return
//        }
        Log.d(LOG_TAG, "Will show ad.")
        appOpenAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
            /** Called when full screen content is dismissed.  */
            override fun onAdDismissedFullScreenContent() {
                // Set the reference to null so isAdAvailable() returns false.
                appOpenAd = null
//                isShowingAd = false
                Log.d(LOG_TAG, "onAdDismissedFullScreenContent.")
//                Toast.makeText(activity, "onAdDismissedFullScreenContent", Toast.LENGTH_SHORT).show()
                loadAndShowAdCompleteListener.onAdDismissedFull()
                //                if (googleMobileAdsConsentManager.canRequestAds()) {
                //                    loadAd(activity, loadAndShowAdCompleteListener);
                //                }
            }

            /** Called when fullscreen content failed to show.  */
            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                appOpenAd = null
//                isShowingAd = false
                Log.d(LOG_TAG, "onAdFailedToShowFullScreenContent: " + adError.message)
//                Toast.makeText(activity, "onAdFailedToShowFullScreenContent", Toast.LENGTH_SHORT).show()
                loadAndShowAdCompleteListener.onAdFailedToShowFull()
                //                if (googleMobileAdsConsentManager.canRequestAds()) {
                //                    loadAd(activity, loadAndShowAdCompleteListener);
                //                }
            }

            /** Called when fullscreen content is shown.  */
            override fun onAdShowedFullScreenContent() {
                Log.d(LOG_TAG, "onAdShowedFullScreenContent.")
//                Toast.makeText(activity, "onAdShowedFullScreenContent", Toast.LENGTH_SHORT).show()
            }
        }
//        isShowingAd = true
        appOpenAd!!.show(activity)
    }

}
