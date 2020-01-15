package com.example.tomcat1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.customcommon.util.ToolBarManager
import com.example.customsplash.SplashActivity
import com.example.modulebase.BaseActivity
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolBarManager {

    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.toolBar) }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
////        val intent = Intent(this, SplashActivity::class.java)
////        startActivity(intent)
//    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        presenter = MyPresenter()
//        presenter.initView(toolBar)
        initToolBar()
    }


//    class MySplashActivity :SplashActivity(){
//        override fun initData() {
//            super.initData()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
