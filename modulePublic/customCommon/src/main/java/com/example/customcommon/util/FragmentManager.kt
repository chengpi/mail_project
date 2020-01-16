package com.example.customcommon.util

import com.example.customcommon.R
import com.example.modulebase.BaseFragment

class FragmentManager private constructor(){

    var fragmentMap: HashMap<Int,BaseFragment> = hashMapOf()
//    lateinit var fragment:BaseFragment
    companion object{
        val fragmentManager by lazy { FragmentManager() }
    }
//    inline fun <reified T:BaseFragment>getFragment(tabId:Int):BaseFragment{
//        fragment = lazy { find<T>(tabId) }
//        return fragment
//    }
    fun getFragment(tabId:Int):BaseFragment?{
        return fragmentMap.get(tabId)
    }

}