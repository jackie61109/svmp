package com.fet.svmp.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.orhanobut.logger.Logger


class SplashActivity : AppCompatActivity() {

    private var mPermissions = arrayOf(android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.READ_CONTACTS, android.Manifest.permission.READ_CALENDAR, android.Manifest.permission.WRITE_CALENDAR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val context = this

        val m_permissionCallBackInterface = object : PermissionHelpActivity.PermissionCallBackInterface {
            override fun onGranted(activity: Activity) {
                FirebaseInstanceId.getInstance().instanceId
                        .addOnCompleteListener(OnCompleteListener<InstanceIdResult> { task ->
                            if (!task.isSuccessful) {
                                Logger.w("getInstanceId failed", task.exception)
                                return@OnCompleteListener
                            }

                            // Get new Instance ID token
                            val token = task.result?.token

                            // Log and toast
                            Logger.d("instanceId = $token")
                        })

                Handler().postDelayed(
                        {
                            LoginActivity.start(context)
                            finish()
                        }, 2000)
            }

            override fun onDenied(activity: Activity) {
                activity.finish()
            }
        }

        // Request Permissions
        PermissionHelpActivity.doReqPermissions(this, mPermissions, m_permissionCallBackInterface)
    }
}
