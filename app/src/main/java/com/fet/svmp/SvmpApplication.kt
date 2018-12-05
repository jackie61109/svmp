package com.fet.svmp

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.fet.svmp.customize.Configs
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import io.fabric.sdk.android.Fabric

/**
 * Created by i_jackiechen1 on 2018/12/3 下午2:59.
 */
class SvmpApplication : Application() {

    private val LOG_TAG = "SVMP"

    override fun onCreate() {
        super.onCreate()

        initFabric()
        logInitial()
    }

    private fun initFabric() {
        val crashLyticsKit = Crashlytics.Builder()
                .core(CrashlyticsCore.Builder().disabled(BuildConfig.IS_DEBUG).build())
                .build()
        Fabric.with(this, crashLyticsKit)
    }

    private fun logInitial() {
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return Configs.IS_DEBUG
            }
        })
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)  //是否选择显示线程信息，默认为true
//                .methodCount(0)         //方法数显示多少行，默认2行
//                .methodOffset(7)        //隐藏方法内部调用到偏移量，默认5
//                .logStrategy(customLog) //打印日志的策略，默认LogCat
                .tag(LOG_TAG)   //自定义TAG全部标签，默认PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}
