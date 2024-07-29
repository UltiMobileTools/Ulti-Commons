package com.ultimobiletools.commons.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES
import android.util.DisplayMetrics
import android.view.WindowMetrics
import com.google.android.gms.ads.AdSize

class ScreenUtil {

    fun getAdSize(context: Context, activity: Activity): AdSize {
        val displayMetrics: DisplayMetrics = context.resources.displayMetrics
        var adWidthPixels = displayMetrics.widthPixels
        if (Build.VERSION.SDK_INT >= VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = activity.windowManager.currentWindowMetrics
            adWidthPixels = windowMetrics.bounds.width()
        }
        val density = displayMetrics.density
        val adWidth = (adWidthPixels / density).toInt()
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth)
    }
}
