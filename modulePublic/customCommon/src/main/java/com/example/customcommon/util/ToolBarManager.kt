package com.example.customcommon.util
import android.annotation.SuppressLint
import android.widget.Toolbar
import com.example.customcommon.R

interface ToolBarManager {
    val toolBar:Toolbar
    @SuppressLint("ResourceAsColor")
    fun initToolBar(){
//        toolBar.setTitle("Email(100)")
//        toolBar.setTitleTextColor(R.color.colorBlack)
    }
}