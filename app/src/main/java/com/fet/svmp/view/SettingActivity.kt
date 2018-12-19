package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import com.fet.svmp.R
import com.fet.svmp.databinding.ActivitySettingBinding
import com.fet.svmp.viewModel.SettingViewModel

class SettingActivity : BaseActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, SettingActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivitySettingBinding>(this, R.layout.activity_setting)
        binding.settingVM = SettingViewModel(this)

        setToolBar(this, R.string.title_activity_setting)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return true
    }
}
