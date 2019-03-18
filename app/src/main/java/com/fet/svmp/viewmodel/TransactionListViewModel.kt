package com.fet.svmp.viewmodel

import android.arch.lifecycle.ViewModel
import com.fet.svmp.model.database.dao.AccountInfoDao
import com.fet.svmp.view.BaseActivity
import com.fet.svmp.widget.OrderListAdapter

/**
 * Created by i_jackiechen1 on 2018/12/19 下午4:09.
 */
class TransactionListViewModel(accountDao: AccountInfoDao,context: BaseActivity) : BaseViewModel() {

    val activity = context



    fun changeData() {
        activity.showToast(activity, "123")
    }

    fun getTime() {
        addDisposable()
    }
}