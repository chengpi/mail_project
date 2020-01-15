package com.example.modulebase

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity


/*所有Activity的基类*/
abstract class BaseActivity :AppCompatActivity() , AnkoLogger {
    lateinit var presenter:BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)//去除标题栏
        setStatusBarFontColor(this)//要在setContentView函数之前执行
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

//    abstract fun getLayoutId(context: Context, name:String, type:String):Int

    //
    open protected fun initListener() {

    }
    //初始化数据
    open protected fun initData() {

    }
    //开启新的activity并finish当前界面
    inline fun <reified T:BaseActivity>startActivityAndFinish() {
        startActivity<T>()
        finish()
    }

    private fun setStatusBarFontColor(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 设置状态栏底色白色
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            // 设置状态栏字体黑色
            activity.window.getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or//这行会导致手机状态栏挡住应用的toolBar
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//这行加上会导致手机虚拟导航栏挡住应用的bottomBar
                    or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            )
//            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            window.setStatusBarColor(getResources().getColor(R.color.c_FFFFFF))
//            window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
//            window.setNavigationBarColor(activity.getResources().getColor(R.color.c_FFFFFF))
        }
    }
}