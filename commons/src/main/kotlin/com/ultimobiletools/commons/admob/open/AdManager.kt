package com.ultimobiletools.commons.admob.open

interface AdManager {
    fun onAdLoaded()

    fun onLoadAdFail()

    fun onAdDismissedFull()

    fun onAdFailedToShowFull()
}
