package com.ultimobiletools.commons.hisavana

import android.content.Context
import android.util.Log
import com.hisavana.mediation.config.TAdManager
import com.hisavana.mediation.config.TAdManager.OnCloudCompleteListener

class AdManager(context: Context) {
    val LOG_TAG: String = "TAdManager"

    fun init(
        context: Context?, debug: Boolean, testDevice: Boolean,loadAndShowAdCompleteListener: AdManagerInterface
    ) {
        TAdManager.init(
            context, TAdManager.AdConfigBuilder()
                // 必须设置，请在广告平台申请
                .setAppId(TAdsConstant.APPID)
                // 可选项，是否打印广告日志，默认为false；假如设置为true时会打印log，关键字ADSDK_M、ADSDK_N
                .setDebug(debug)
                // 可选项，是否请求测试广告，默认为false；假如为true时请求广告平台的测试广告，否则请求广告平台的正式广告
                .testDevice(testDevice)
                // 可选项，视频类广告是否全局静音
                .setMuteVideo(false)
                // 可选项，是否在此时进行admob的初始化操作
                .isInitAdMob(false)
                // 可选项，假如开启内置广告功能需要设置，值为zip包的版本号（由运营提供，单位：Long），用于兜底广告的更新
//                .setInternalDefaultAdVersion(defaultAdVersio) // 可选项，该回调配置完成，最长等待15s
                .setCloudCompleteListener(object : OnCloudCompleteListener {
                    override fun onCloudComplete(var1: Int, var2: String?) {
                        Log.d(LOG_TAG, "onCloudComplete:$var2")
                        loadAndShowAdCompleteListener.onCloudComplete()
                    }
                }).build()
        )
    }
}
