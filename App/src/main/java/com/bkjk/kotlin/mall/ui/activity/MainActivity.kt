package com.bkjk.kotlin.mall.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.ui.activity.BaseActivity
import com.bkjk.kotlin.mall.R
import com.bkjk.kotlin.mall.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mHomeFragment by lazy { HomeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBottomNavBar.checkCartBadge(20)

        initView()
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mHomeContainer, mHomeFragment)
        manager.commit()
    }
}
