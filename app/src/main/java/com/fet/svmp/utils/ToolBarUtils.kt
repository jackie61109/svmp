package com.fet.svmp.utils

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.fet.svmp.R


object ToolBarUtils {

    fun setDefaultStyle(activity: AppCompatActivity, titleRes: Int) {
        val toolbar = activity.findViewById<Toolbar>(R.id.ToolBar)
        val title = toolbar.findViewById<TextView>(R.id.toolbar_title)
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)

        title.text = activity.getString(titleRes)
        toolbar.title = ""
        activity.setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { activity.onBackPressed() }
    }

}
