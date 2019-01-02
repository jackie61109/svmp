package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.fet.svmp.R

/**
 * Created by i_jackiechen1 on 2018/11/30 上午10:21.
 */
class TransactionListActivity : BaseActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, TransactionListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_transaction_list)

        setToolBar(this, R.string.title_activity_transaction_list)

    }
}