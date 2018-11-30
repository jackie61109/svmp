package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R

class MainActivity : AppCompatActivity() {


    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(activity, intent, null)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
