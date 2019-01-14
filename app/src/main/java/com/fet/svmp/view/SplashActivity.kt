package com.fet.svmp.view

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val context = this
        account = SvmpDataBase.getInstance(context).AccountInfoDao().getAll()

    }

    override fun onResume() {
        super.onResume()
        if (!isPermissionGranted(mPermissions)) {
            ActivityCompat.requestPermissions(this, mPermissions, 123)
        } else {
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
                            LoginActivity.start(this)
                        } else {
                            MainActivity.start(this)
                        }
                        finish()
                    }, 2000)
        }
    }

    private fun isPermissionGranted(mPermissions: Array<String>): Boolean {
        for (permission in mPermissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }

}
