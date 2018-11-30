package com.fet.svmp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fet.svmp.test.TestGetSeter

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        TestGetSeter("1",2,0.3)
        MainActivity.start(this)

    }
}
