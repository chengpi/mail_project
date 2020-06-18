package com.example.tomcat1

//import android.widget.Toolbar

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.example.customcommon.util.BottomBarManager
import com.example.customcommon.util.FragmentManager
import com.example.customcommon.util.ToolBarManager
import com.example.modulebase.BaseActivity
import com.example.modulebase.BaseFragment
import com.example.tomcat1.fragment.FriendsFragment
import com.example.tomcat1.fragment.MailFragment
import com.example.tomcat1.fragment.MeFragment
import org.jetbrains.anko.find
import java.lang.Exception

class MainActivity : BaseActivity(),ToolBarManager {
//class MainActivity : BaseActivity(),ToolBarManager,BottomBarManager {

    //惰性加载
    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.toolBar) }
//    override val bottomBar: BottomNavigationBar by lazy { find<BottomNavigationBar>(R.id.bottomBar) }
//    val webViewContainer by lazy {find<FrameLayout>(R.id.container)}
    val webView: WebView by lazy {find<WebView>(R.id.wv_webview)}

//    val webViewContainer = findViewById(R.id.container) as FrameLayout
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
////        val intent = Intent(this, SplashActivity::class.java)
////        startActivity(intent)
//    }
//    val myFragmentManager:FragmentManager by lazy { FragmentManager.fragmentManager }

    init {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        presenter = MyPresenter()
//        presenter.initView(toolBar)
//        setSupportActionBar(toolBar)
//        setSupportActionBar(toolBar as androidx.appcompat.widget.Toolbar)
//        myFragmentManager.fragmentMap.set(0,MailFragment() as BaseFragment)
//        myFragmentManager.fragmentMap.set(1,FriendsFragment() as BaseFragment)
//        myFragmentManager.fragmentMap.set(2,  MeFragment() as BaseFragment)
//        webViewContainer.addView(webView)

        initToolBar()
//        initBottomBar()

        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.allowFileAccess = true// 设置允许访问文件数据
        webSettings.setSupportZoom(true)//支持缩放
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.domStorageEnabled = true
        webSettings.databaseEnabled = true
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.allowContentAccess = true

        webView.setBackgroundColor(Color.TRANSPARENT)
        //访问网页
        webView.loadUrl("file:///android_asset/web/index.html")
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView!!.setOnKeyListener(OnKeyEvent)
        webView.setWebViewClient(webClient)

//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, myFragmentManager.getFragment(0) as BaseFragment)
//        transaction.commit()

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

    override fun initListener() {

//        bottomBar.setTabSelectedListener(object:BottomNavigationBar.OnTabSelectedListener {
//            //这里也可以使用SimpleOnTabSelectedListener
//
//            override fun onTabSelected(position:Int) {//未选中 -> 选中
//
////                val transaction = supportFragmentManager.beginTransaction()
////                if (myFragmentManager.getFragment(position) == null){
//////                    myFragmentManager.fragmentMap.set()
////                    println("取值为空")
////                }
////                println(position)
////                when(position){
////                    0->println("mail")
////                    1-> println("friends")
////                    2-> println("me")
////                }
//                when(position){
//                    0->{
//                        if (webView?.canGoBack()) {
//                            webView.goBack()
//                        }
//                    }
//                    1->{
//                        webView.loadUrl("https://www.baidu.com/")
//                    }
//
//                }
//
////                transaction.replace(R.id.container, myFragmentManager.getFragment(position) as BaseFragment)
////                transaction.commit()
//
//            }
//
//            override fun onTabUnselected(position:Int) {//选中 -> 未选中
//            }
//
//            override fun onTabReselected(position:Int) {//选中 -> 选中
//            }
//        })
    }

//    class MySplashActivity :SplashActivity(){
//        override fun initData() {
//            super.initData()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
    private val OnKeyEvent = View.OnKeyListener { v, keyCode, event ->
        val action = event.action
        val webView = v as WebView
        if (KeyEvent.ACTION_DOWN == action && KeyEvent.KEYCODE_BACK == keyCode) {
            if (webView?.canGoBack()) {
                webView.goBack()
                return@OnKeyListener true
            }else{
//                webView.loadUrl("https://www.baidu.com/")
//                webView.setWebViewClient(webClient)
//                return@OnKeyListener true
            }
        }
        false
    }
}

