package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.fet.svmp.R

class SettingActivity : BaseActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, SettingActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        setToolBar(this, R.string.title_activity_setting)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return true
    }
}
