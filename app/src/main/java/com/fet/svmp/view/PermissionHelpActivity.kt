package com.fet.svmp.view

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import com.fet.svmp.R
import com.orhanobut.logger.Logger
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


class PermissionHelpActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private var m_request_permissions: Array<String>? = null
    private var m_update_id: String? = null
    private var m_paymenthod: String? = null
    private var hasDeniedPermission = false
    private val m_permissionCallBackInterface: PermissionCallBackInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        m_request_permissions = intent.getStringArrayExtra(EXTRA_REQUEST_PERMISSIONS)
        m_update_id = intent.getStringExtra(EXTRA_PAYMENT_METHOD_UPDATE_ID)
        m_paymenthod = intent.getStringExtra(EXTRA_PAYMENT_METHOD_PAYMETHOD)
        hasDeniedPermission = false
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
            super.setResult(Activity.RESULT_CANCELED, Intent())
            finish()
        }
    }

    @AfterPermissionGranted(REQUEST_PERMISSIONS_RESULT)
    private fun doRequestPermissions() {
        if (m_request_permissions!![0] == Manifest.permission.WRITE_SETTINGS) {
            //            Dialog dialog = DialogUtils.createConfirmDialog(PermissionHelpActivity.this,
            //                    getString(R.string.request_permission),
            //                    getString(R.string.txt_permissions_brightness),
            //                    new DialogButtonListener() {
            //                        @Override
            //                        public void onClick(View v) {
            //                            dialog.dismiss();
//                                        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + PermissionHelpActivity.this.getPackageName()));
//                                        startActivityForResult(intent, BaseActivity.PERMISSIONS_WRITE_SETTINGS);
            //                        }
            //                    });
            //            dialog.show();

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Permission to access the microphone is required for this app to record audio.")
                    .setTitle("Permission required")

            builder.setPositiveButton("OK")
            { dialog, id ->
                Logger.i("Clicked")
                val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + PermissionHelpActivity::class.java.name))
                startActivityForResult(intent, 1)
            }

            val dialog = builder.create()
            dialog.show()
        } else if (EasyPermissions.hasPermissions(this, *m_request_permissions!!)) {
            super.setResult(Activity.RESULT_OK, Intent())
            finish()
        } else {
            if (!hasDeniedPermission) {
                hasDeniedPermission = true
                EasyPermissions.requestPermissions(this, getString(R.string.request_permission), REQUEST_PERMISSIONS_RESULT, *m_request_permissions!!)
            } else {
                super.setResult(Activity.RESULT_CANCELED, Intent())
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
        val EXTRA_PAYMENT_METHOD_UPDATE_ID = "extra_payment_method_update_id"
        val EXTRA_PAYMENT_METHOD_PAYMETHOD = "extra_payment_method_paymethod"

        const val REQUEST_PERMISSIONS_RESULT = 0x991
        val SETTING_DENIED_RESULT = 0x992
        //private AppSettingsDialog.Builder appSettingsDialog;

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
