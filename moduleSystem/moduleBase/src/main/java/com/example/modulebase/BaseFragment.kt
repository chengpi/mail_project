package com.example.modulebase

//import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger

//所有Fragment的基类
abstract class BaseFragment : Fragment(),AnkoLogger {
    lateinit var mActivity: AppCompatActivity
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    //fragment初始化
    protected fun init() {

    }
    //
    abstract fun initView(): View?

    protected fun initListener() {

    }
    protected fun initData() {

    }
    fun getParentActivity(): BaseActivity {
        return mActivity as BaseActivity
    }

}