package com.example.customsplash

//import android.os.Parcel
//import android.os.Parcelable
import android.content.Context
import com.example.customsplash.R
import com.example.modulebase.BaseActivity

class SplashActivity() :BaseActivity(){

    override fun getLayoutId(): Int {

        return R.layout.activity_splash
    }

    override fun getLayoutId(context: Context, name: String, type: String): Int {
        return context.getResources().getIdentifier(name, type, context.getPackageName())
    }
}