package com.example.modulebase

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger

/*所有Activity的基类*/
abstract class BaseActivity :AppCompatActivity() , AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
//        setContentView(getLayoutId(this,"icon_welcome_mail","layout"))
        initListener()
        initData()
    }
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {//方法重载错误
//        super.onCreate(savedInstanceState, persistentState)
//
//    }

    abstract fun getLayoutId():Int //抽象方法
//    abstract fun getLayoutId(context: Context):Int //抽象方法

    abstract fun getLayoutId(context: Context, name:String, type:String):Int

    //
    protected fun initListener() {

    }
    //初始化数据
    protected fun initData() {

    }
}