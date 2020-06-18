package com.example.modulebase

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates


abstract class BaseApplication:Application() {
    /**
     * 系统上下文
     */
//    private var mAppContext: Context? = null

    override fun onCreate() {
        super.onCreate()
        mAppContext = applicationContext
    }

    /**
     * 获取系统上下文：用于ToastUtil类
     */
    companion object {
        var instance: BaseApplication by Delegates.notNull()
        private var mAppContext: Context? = null
        fun getAppContext(): Context? {
            return mAppContext
        }
    }

}