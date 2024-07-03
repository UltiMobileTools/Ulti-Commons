package com.ultimobiletools.commons.compose.extensions

import android.app.Activity
import android.content.Context
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.extensions.baseConfig
import com.ultimobiletools.commons.extensions.redirectToRateUs
import com.ultimobiletools.commons.extensions.toast
import com.ultimobiletools.commons.helpers.BaseConfig

val Context.config: BaseConfig get() = BaseConfig.newInstance(applicationContext)

fun Activity.rateStarsRedirectAndThankYou(stars: Int) {
    if (stars == 5) {
        redirectToRateUs()
    }
    toast(R.string.thank_you)
    baseConfig.wasAppRated = true
}
