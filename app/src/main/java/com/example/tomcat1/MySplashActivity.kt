package com.example.tomcat1
//
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.example.customsplash.SplashActivity
import org.jetbrains.anko.startActivity

//import kotlinx.android.synthetic.main.activity_splash.*
//import com.example.customsplash.R

class MySplashActivity : SplashActivity(){
//    val imageView = findViewById<ImageView>(R.id.icon_welcome_mail)
//    val textView = findViewById<TextView>(R.id.text_welcome_mail)

    override fun initData() {
        super.initData()
//        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setDuration(2000L)
//        ViewCompat.animate(textView).scaleX(1.0f).scaleY(1.0f).setDuration(2000L)

//        val intent = Intent(this, MainActivity::class.java)
//        if(isLoaded) {
//            startActivity(intent)
//        }

    }

    override fun onAnimationEnd(view: View?) {
        super.onAnimationEnd(view)
        startActivity<MainActivity>()
    }
}