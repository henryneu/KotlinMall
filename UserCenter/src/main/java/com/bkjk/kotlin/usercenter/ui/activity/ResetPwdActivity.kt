package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.ext.enable
import com.bkjk.kotlin.baselibrary.ext.onClick
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.ResetPwdPresenter
import com.bkjk.kotlin.usercenter.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.*

/**
 * 重置密码界面
 */
class ResetPwdActivity: BaseMVPActivity<ResetPwdPresenter>(), ResetPwdView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getTitleView().text = resources.getString(R.string.user_center_s_reset_pwd)

        mConfirmBtn.enable(mPwdEt, {isBtnEnabled()})
        mConfirmBtn.enable(mPwdConfirmEt, {isBtnEnabled()})

        mConfirmBtn.onClick {
            if (!(mPwdEt.text.toString().equals(mPwdConfirmEt.text.toString()))) {
                toast(resources.getString(R.string.user_center_s_pwd_not_conformity))
                return@onClick
            }
            // 测试使用
            startActivity(intentFor<LoginActivity>().singleTop().clearTop())
            mPresenter.resetPwd(intent.getStringExtra("phone_num"), mPwdEt.text.toString())
        }
    }

    /**
     * 重置密码回调
     */
    override fun onRestPwdResult(result: String) {
        toast(result)
        // 重置密码成功后跳转到登录界面
        // startActivity(intentFor<LoginActivity>().singleTop().clearTop())
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
     * 判断 Button 是否可用
     */
    private fun isBtnEnabled(): Boolean {
        return mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}