package com.example.tomcat1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customsplash.SplashActivity
import com.example.modulebase.BaseActivity

class MainActivity : BaseActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
////        val intent = Intent(this, SplashActivity::class.java)
////        startActivity(intent)
//    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


//    class MySplashActivity :SplashActivity(){
//        override fun initData() {
//            super.initData()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
