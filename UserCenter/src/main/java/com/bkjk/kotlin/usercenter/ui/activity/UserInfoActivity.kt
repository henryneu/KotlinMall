package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.UserInfoPresenter
import com.bkjk.kotlin.usercenter.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 用户信息界面
 */
class UserInfoActivity: BaseMVPActivity<UserInfoPresenter>(), UserInfoView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getRightView().visibility = View.VISIBLE

    }

    /**
     * 初始化依赖注入
     */
    override fun initInjectionComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 处理点击事件
     */
    override fun onClick(view: View) {
        when(view.id) {

        }
    }
}