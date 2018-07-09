package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.bkjk.kotlin.baselibrary.ext.enable
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.LoginPresenter
import com.bkjk.kotlin.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

/**
 * 登录界面
 */
class LoginActivity: BaseMVPActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getTitleView().text = resources.getString(R.string.user_center_s_login_in)
        mHeaderBar.getRightView().text = resources.getString(R.string.user_center_s_register_btn)
        mHeaderBar.getRightView().visibility = View.VISIBLE
        mHeaderBar.getRightView().onClick(this)

        mLoginBtn.setOnClickListener(this)

        mLoginBtn.enable(mMobileEt, {isBtnEnabled()})
        mLoginBtn.enable(mPwdEt, {isBtnEnabled()})
    }

    /**
     * 登录回调
     */
    override fun onLoginResult(result: UserInfo) {

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
            R.id.mHeaderBarRt -> {startActivity<RegisterActivity>()}
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
            }
        }
    }

    /**
     * 判断 Button 是否可用
     */
    private fun isBtnEnabled(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}