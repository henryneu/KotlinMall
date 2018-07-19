package com.bkjk.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.bkjk.kotlin.baselibrary.ui.activity.BaseActivity
import com.bkjk.kotlin.mall.R
import com.bkjk.kotlin.mall.ui.fragment.HomeFragment
import com.bkjk.kotlin.mall.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

    }
}
