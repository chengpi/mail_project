package com.example.customcommon.util

import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.customcommon.R

interface BottomBarManager {
    val bottomBar:BottomNavigationBar
    fun initBottomBar(){
        bottomBar.setMode(BottomNavigationBar.MODE_FIXED)
        bottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottomBar.setBarBackgroundColor(R.color.colorWhite) //换成你的背景色即可
        bottomBar.setInActiveColor(R.color.color_696969)

        bottomBar.addItem(BottomNavigationItem(R.drawable.cancel, "回退"))
            .setActiveColor(R.color.color_6A5ACD)
        bottomBar.addItem(BottomNavigationItem(R.drawable.home, "主页")).
            setActiveColor(R.color.color_6A5ACD)
//        bottomBar.addItem(BottomNavigationItem(R.drawable.ic_friends_contact_normal, "Friends")).
//            setActiveColor(R.color.color_6A5ACD)
//        bottomBar.addItem(BottomNavigationItem(R.drawable.ic_me_normal, "Me")).
//            setActiveColor(R.color.color_6A5ACD)
        bottomBar.setFirstSelectedPosition(0)
            .initialise()
    }
}