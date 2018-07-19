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

class MainActivity : BaseActivity() {

    // 放置所有的 Fragment
    private val mFragmentStack = Stack<Fragment>()
    // 首页 Fragment
    private val mHomeFragment by lazy { HomeFragment() }
    // 商品分类 Fragment
    private val mCategoryFragment by lazy { HomeFragment() }
    // 购物车 Fragment
    private val mCartFragment by lazy { HomeFragment() }
    // 消息 Fragment
    private val mMsgFragment by lazy { HomeFragment() }
    // 我的 Fragment
    private val mMineFragment by lazy { MineFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBottomNavBar.checkCartBadge(20)

        // 初始化所有的 Fragment
        initFragment()
        // 初始化底部导航菜单的事件
        initBottomNav()
        changeFragment(0)
    }

    /**
     * 初始化所有的 Fragment
     */
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mHomeContainer, mHomeFragment)
        manager.add(R.id.mHomeContainer, mCategoryFragment)
        manager.add(R.id.mHomeContainer, mCartFragment)
        manager.add(R.id.mHomeContainer, mMsgFragment)
        manager.add(R.id.mHomeContainer, mMineFragment)
        manager.commit()

        mFragmentStack.add(mHomeFragment)
        mFragmentStack.add(mCategoryFragment)
        mFragmentStack.add(mCartFragment)
        mFragmentStack.add(mMsgFragment)
        mFragmentStack.add(mMineFragment)
    }

    /**
     * 初始化底部导航菜单的事件
     */
    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mFragmentStack) {
            manager.hide(fragment)
        }
        manager.show(mFragmentStack[position])
        manager.commit()
    }
}
