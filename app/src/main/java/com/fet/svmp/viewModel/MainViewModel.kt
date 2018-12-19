package com.fet.svmp.viewModel

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.fet.svmp.R
import com.fet.svmp.view.SettingActivity
import com.fet.svmp.view.TransactionListActivity

/**
 * Created by i_jackiechen1 on 2018/12/6 下午2:31.
 */
class MainViewModel(activity: Activity, application: Application) :AndroidViewModel(application){

    val context = activity

    fun btnTransactionList() {
        TransactionListActivity.start(context)
    }

    fun btnSetting() {
        SettingActivity.start(context)
    }

    fun btnSettingText(): String = context.getString(R.string.title_activity_setting)

    fun btnTransactionListText(): String = context.getString(R.string.title_activity_transaction_list)
}