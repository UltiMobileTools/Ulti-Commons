package com.ultimobiletools.commons.samples

import android.app.Application
import com.github.ajalt.reprint.core.Reprint
import com.ultimobiletools.commons.hisavana.AdManager
import com.ultimobiletools.commons.hisavana.AdManagerInterface
import com.ultimobiletools.commons.hisavana.TAdsConstant

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Reprint.initialize(this)
        TAdsConstant.APPID = "240807hdOpgzf8"
        TAdsConstant.AD_OPEN_UNIT_ID = "240807o4bavR1a"
    }

}
