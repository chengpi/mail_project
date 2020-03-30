package com.example.customsplash

//import android.os.Parcel
//import android.os.Parcelable
import android.content.Context
import android.view.View
import android.view.ViewPropertyAnimator
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.customcommon.util.AppUtils
import com.example.customsplash.R
import com.example.modulebase.BaseActivity
import com.example.modulebase.BaseApplication
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

open class SplashActivity() :BaseActivity(),ViewPropertyAnimatorListener{
//    var isLoaded = false

    override fun getLayoutId(): Int {

        return R.layout.activity_splash
    }

    override fun initData() {
//        super.initData()
        AppUtils.closeAndroidPDialog(BuildConfig.APPLICATION_ID)
        ViewCompat.animate(icon_welcome_mail).scaleX(1.0f).scaleY(1.0f).setDuration(3000L).setListener(this)
//        ViewCompat.animate(icon_welcome_mail).scaleY(1.0f)
        ViewCompat.animate(text_welcome_mail).scaleX(1.0f).scaleY(1.0f).setDuration(3000L)
//        ViewCompat.animate(text_welcome_mail).scaleY(1.0f)
//        isLoaded = true

    }

    override fun onAnimationEnd(view: View?) {
//        BaseApplication.getAppContext()?.getResources()?.getString(R.string.app_name)
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

}