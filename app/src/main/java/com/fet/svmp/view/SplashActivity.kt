package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R
import com.fet.svmp.SvmpDataBase
import com.fet.svmp.model.database.entities.AccountInfo
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId.getInstance
import com.google.firebase.iid.InstanceIdResult
import com.orhanobut.logger.Logger


class SplashActivity : AppCompatActivity() {

    private var mPermissions = arrayOf(android.Manifest.permission.READ_CALENDAR, android.Manifest.permission.WRITE_CALENDAR,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
    var account: List<AccountInfo>? = null
    var m_permissionCallBackInterface: PermissionHelpActivity.PermissionCallBackInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val context = this
        account = SvmpDataBase.getInstance(context).AccountInfoDao().getAll()
        m_permissionCallBackInterface = object : PermissionHelpActivity.PermissionCallBackInterface {
            override fun onGranted(activity: Activity) {
                getInstance().instanceId
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
                            if (account?.size == 0) {
                                LoginActivity.start(context)
                            } else {
                                MainActivity.start(context)
                            }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PermissionHelpActivity.REQUEST_PERMISSIONS_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                m_permissionCallBackInterface?.onGranted(this)
            } else {
                m_permissionCallBackInterface?.onDenied(this)
            }
        }
    }
}
