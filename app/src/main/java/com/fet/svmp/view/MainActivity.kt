package com.fet.svmp.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.fet.svmp.R
import com.fet.svmp.databinding.ActivityMainBinding
import com.fet.svmp.viewModel.MainViewModel

class MainActivity : BaseActivity() {


    companion object {
        fun start(activity: Context) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(activity, intent, null)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.mainViewModel = MainViewModel(this)

        setToolBar(this, R.string.title_activity_main)
    }

}
