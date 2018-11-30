package com.fet.svmp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivities
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.test.TestGetSeter

class MainActivity : AppCompatActivity() {

    var hello = 1


    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(activity, intent, null)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// 宣告可以指定null值的變數
        var name2: String? = "Mary"

// 可以指定null值
        name2 = null

// 編譯錯誤，因為可以指定null值的變數
// 不允許直接呼叫函式
// println(name2.length)
        println(name2?.length)
        sayHello("Kotlin")

        println(TestGetSeter().a)
        println(TestGetSeter().b)
        println(TestGetSeter().c)
    }

    fun sayHello(name: String) {
        println("Hello! $name!")
    }
}
