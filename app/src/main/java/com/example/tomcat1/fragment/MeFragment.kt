package com.example.tomcat1.fragment

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.Gravity
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.example.modulebase.BaseFragment
import java.lang.Exception

class MeFragment:BaseFragment() {
    override fun initView(): View? {
        val text = TextView(context)
        text.gravity = Gravity.CENTER
        text.setTextColor(Color.RED)
        text.text = javaClass.simpleName
        return text
    }
    private val webClient = object : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            //使用WebView加载显示url
            if (url.startsWith("http://") || url.startsWith("https://")) {
                //加载的url是http/https协议地址
                view.loadUrl(url);
                return false; //返回false表示此url默认由系统处理,url未加载完成，会继续往下走

            } else { //加载的url是自定义协议地址
                try {
                    var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    this.startActivity(intent);
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return true;
            }
//            view.loadUrl(url);
//            //返回true
//            return true;
        }
    }
}