package com.example.tomcat1.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.modulebase.BaseFragment

class FriendsFragment:BaseFragment() {
    override fun initView(): View? {
        val text = TextView(context)
        text.gravity = Gravity.CENTER
        text.setTextColor(Color.BLUE)
        text.text = javaClass.simpleName
        return text
    }
}