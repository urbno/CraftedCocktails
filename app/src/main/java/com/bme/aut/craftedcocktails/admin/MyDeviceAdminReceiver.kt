package com.bme.aut.craftedcocktails.admin

import android.app.admin.DeviceAdminReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import timber.log.Timber

class MyDeviceAdminReceiver : DeviceAdminReceiver() {

    private val TAG = MyDeviceAdminReceiver::class.java.simpleName

    companion object {
        fun getComponentName(context: Context): ComponentName {
            return ComponentName(context.applicationContext, MyDeviceAdminReceiver::class.java)
        }

        private val TAG = MyDeviceAdminReceiver::class.java.simpleName
    }

    override fun onLockTaskModeEntering(context: Context, intent: Intent, pkg: String) {
        super.onLockTaskModeEntering(context, intent, pkg)
        Timber.d("$TAG onLockTaskModeEntering")
    }

    override fun onLockTaskModeExiting(context: Context, intent: Intent) {
        super.onLockTaskModeExiting(context, intent)
        Timber.d("$TAG onLockTaskModeExiting")
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        Timber.d("$TAG Device Admin Disabled")
    }

    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Timber.d("$TAG Device Admin Enabled")
    }
}