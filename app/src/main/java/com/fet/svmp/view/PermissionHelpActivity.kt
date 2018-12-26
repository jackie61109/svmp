package com.fet.svmp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


class PermissionHelpActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private var m_request_permissions: Array<String>? = null
    private var hasDeniedPermission = false
    private val m_permissionCallBackInterface: PermissionCallBackInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        m_request_permissions = intent.getStringArrayExtra(EXTRA_REQUEST_PERMISSIONS)
        setVisible(true)
        doRequestPermissions()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    @AfterPermissionGranted(REQUEST_PERMISSIONS_RESULT)
    private fun doRequestPermissions() {
        if (EasyPermissions.hasPermissions(this, *m_request_permissions!!)) {
            setResult(Activity.RESULT_OK)
            finish()
        } else {
            if (!hasDeniedPermission) {
                hasDeniedPermission = true
                EasyPermissions.requestPermissions(this, getString(R.string.request_permission), REQUEST_PERMISSIONS_RESULT, *m_request_permissions!!)
            } else {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    interface PermissionCallBackInterface {
        fun onGranted(activity: Activity)

        fun onDenied(activity: Activity)
    }

    companion object {

        val EXTRA_REQUEST_PERMISSIONS = "extra_request_permissions"

        const val REQUEST_PERMISSIONS_RESULT = 0x991

        /**
         * Request Permissions
         */
        fun doReqPermissions(activity: Activity, permissions: Array<String>, callBack: PermissionCallBackInterface?) {
            if (EasyPermissions.hasPermissions(activity, *permissions)) {
                callBack?.onGranted(activity)
            } else {
                PermissionHelpActivity.start(activity, permissions, null)
            }
        }

        fun start(activity: Activity, permissions: Array<String>, intent: Intent?) {
            var intent = intent
            if (intent == null) {
                intent = Intent()
            }
            intent.setClass(activity, PermissionHelpActivity::class.java)
            intent.putExtra(EXTRA_REQUEST_PERMISSIONS, permissions)
            activity.startActivityForResult(intent, REQUEST_PERMISSIONS_RESULT)
        }
    }
}
