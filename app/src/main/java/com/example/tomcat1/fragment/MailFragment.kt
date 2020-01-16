package com.example.tomcat1.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView

import com.example.modulebase.BaseFragment
import com.example.tomcat1.R

class MailFragment:BaseFragment() {
    override fun initView(): View? {
        val text = TextView(context)
        text.gravity = Gravity.CENTER
        text.setTextColor(resources.getColor(R.color.colorPrimary))
        text.text = javaClass.simpleName
        return text
    }
}