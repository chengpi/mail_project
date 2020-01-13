package com.example.tomcat1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customsplash.SplashActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)
    }

//    class MySplashActivity :SplashActivity(){
//        override fun initData() {
//            super.initData()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
