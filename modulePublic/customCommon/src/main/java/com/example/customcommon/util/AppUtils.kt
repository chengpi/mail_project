package com.example.customcommon.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import java.lang.reflect.Field
import java.lang.reflect.Method

object AppUtils {
    /**
     * 获取app版本号
     *
     * @param context
     * @return
     */
    fun getAppVersionName(context: Context): String? {
        try {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            return "v" + packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }
    //安卓系统对于app应用调用一些权限时进行弹框提示警告
    @SuppressLint("PrivateApi")
    fun closeAndroidPDialog(applicationId: String) {
        try {
            val aClass =
                Class.forName("android.content.pm.PackageParser${applicationId}")
            val declaredConstructor = aClass.getDeclaredConstructor(String::class.java)
            declaredConstructor.setAccessible(true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            val cls = Class.forName("android.app.ActivityThread")
            val declaredMethod: Method = cls.getDeclaredMethod("currentActivityThread")
            declaredMethod.setAccessible(true)
            val activityThread: Any = declaredMethod.invoke(null)
            val mHiddenApiWarningShown: Field = cls.getDeclaredField("mHiddenApiWarningShown")
            mHiddenApiWarningShown.setAccessible(true)
            mHiddenApiWarningShown.setBoolean(activityThread, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}