package com.fet.svmp.viewModel

import com.fet.svmp.view.BaseActivity
import com.fet.svmp.widget.OrderListAdapter

/**
 * Created by i_jackiechen1 on 2018/12/19 下午4:09.
 */
class TransactionListViewModel(context: BaseActivity, adapter: OrderListAdapter) {

    val activity = context
    private val orderListAdapter: OrderListAdapter = adapter

    fun changeData() {
        activity.showToast(activity, "123")
    }

    fun resetAdapter(): OrderListAdapter {
        return orderListAdapter
    }

    fun getTime() {

    }
}