package com.fet.svmp.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.fet.svmp.utils.ToolBarUtils

/**
 * Created by i_jackiechen1 on 2018/11/30 下午4:50.
 */
open class BaseActivity : AppCompatActivity() {

    open fun setToolBar(activity: AppCompatActivity, titleRes: Int) {
        ToolBarUtils.setDefaultStyle(activity, titleRes)
    }

    open fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}
