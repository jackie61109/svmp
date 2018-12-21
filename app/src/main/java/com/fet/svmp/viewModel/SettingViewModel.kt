package com.fet.svmp.viewModel

import android.app.Activity
import android.content.Intent
import com.fet.svmp.SvmpDataBase
import com.fet.svmp.customize.Configs
import com.fet.svmp.view.SplashActivity

/**
 * Created by i_jackiechen1 on 2018/12/19 下午4:09.
 */
class SettingViewModel(context: Activity) {

    val activity = context

    fun logout() {

        SvmpDataBase.getInstance(activity).AccountInfoDao().deleteAll()

        val intent = Intent(activity, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(intent)
        activity.finish()
    }

    fun getVersionName(): String {

        if (Configs.IS_DEBUG) {
            return Configs.FLAVOR + "_" + Configs.VERSION_NAME + "_" + Configs.VERSION_TYPE
        }
        return Configs.VERSION_NAME
    }

    fun getAccountName(): String {
        val accountItem = SvmpDataBase.getInstance(activity).AccountInfoDao().getAll()?.get(0)

        return accountItem?.account ?: ""
    }
}