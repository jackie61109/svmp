package com.fet.svmp.view

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
                {
                    LoginActivity.start(this)
                    finish()
                }, 2000)


    }
}
