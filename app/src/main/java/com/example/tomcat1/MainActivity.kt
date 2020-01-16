package com.example.tomcat1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
//import android.widget.Toolbar
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.example.customcommon.util.BottomBarManager
import com.example.customcommon.util.FragmentManager
import com.example.customcommon.util.ToolBarManager
import com.example.customsplash.SplashActivity
import com.example.modulebase.BaseActivity
import com.example.modulebase.BaseFragment
import com.example.tomcat1.fragment.FriendsFragment
import com.example.tomcat1.fragment.MailFragment
import com.example.tomcat1.fragment.MeFragment
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolBarManager,BottomBarManager {

    //惰性加载
    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.toolBar) }
    override val bottomBar: BottomNavigationBar by lazy { find<BottomNavigationBar>(R.id.bottomBar) }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
////        val intent = Intent(this, SplashActivity::class.java)
////        startActivity(intent)
//    }
    val myFragmentManager:FragmentManager by lazy { FragmentManager.fragmentManager }

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
        myFragmentManager.fragmentMap.set(0,MailFragment() as BaseFragment)
        myFragmentManager.fragmentMap.set(1,FriendsFragment() as BaseFragment)
        myFragmentManager.fragmentMap.set(2,  MeFragment() as BaseFragment)
        initToolBar()
        initBottomBar()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, myFragmentManager.getFragment(0) as BaseFragment)
        transaction.commit()


    }

    override fun initListener() {

        bottomBar.setTabSelectedListener(object:BottomNavigationBar.OnTabSelectedListener {
            //这里也可以使用SimpleOnTabSelectedListener

            override fun onTabSelected(position:Int) {//未选中 -> 选中

                val transaction = supportFragmentManager.beginTransaction()
//                if (myFragmentManager.getFragment(position) == null){
////                    myFragmentManager.fragmentMap.set()
//                    println("取值为空")
//                }
//                println(position)
//                when(position){
//                    0->println("mail")
//                    1-> println("friends")
//                    2-> println("me")
//                }

                transaction.replace(R.id.container, myFragmentManager.getFragment(position) as BaseFragment)
                transaction.commit()
            }

            override fun onTabUnselected(position:Int) {//选中 -> 未选中
            }

            override fun onTabReselected(position:Int) {//选中 -> 选中
            }
        })
    }

//    class MySplashActivity :SplashActivity(){
//        override fun initData() {
//            super.initData()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}

