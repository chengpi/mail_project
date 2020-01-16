package com.example.tomcat1.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView

import com.example.modulebase.BaseFragment
import com.example.tomcat1.R

class MeFragment:BaseFragment() {
    override fun initView(): View? {
        val text = TextView(context)
        text.gravity = Gravity.CENTER
        text.setTextColor(Color.RED)
        text.text = javaClass.simpleName
        return text
    }
}