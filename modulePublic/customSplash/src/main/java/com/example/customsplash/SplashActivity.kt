package com.example.customsplash

//import android.os.Parcel
//import android.os.Parcelable
import android.content.Context
import android.view.View
import android.view.ViewPropertyAnimator
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.customsplash.R
import com.example.modulebase.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

open class SplashActivity() :BaseActivity(),ViewPropertyAnimatorListener{
//    var isLoaded = false

    override fun getLayoutId(): Int {

        return R.layout.activity_splash
    }

    override fun initData() {
//        super.initData()
        ViewCompat.animate(icon_welcome_mail).scaleX(1.0f).scaleY(1.0f).setDuration(2000L).setListener(this)
//        ViewCompat.animate(icon_welcome_mail).scaleY(1.0f)
        ViewCompat.animate(text_welcome_mail).scaleX(1.0f).scaleY(1.0f).setDuration(2000L)
//        ViewCompat.animate(text_welcome_mail).scaleY(1.0f)
//        isLoaded = true

    }

    override fun onAnimationEnd(view: View?) {
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

}