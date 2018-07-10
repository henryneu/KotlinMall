package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.bkjk.kotlin.baselibrary.ext.enable
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.baselibrary.utils.PhoneNumUtils
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.ForgetPwdPresenter
import com.bkjk.kotlin.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 忘记密码界面
 */
class ForgetPwdActivity: BaseMVPActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getTitleView().text = resources.getString(R.string.user_center_s_forgeted_pwd)

        mVerifyCodeBtn.setOnClickListener(this)
        mNextStepBtn.setOnClickListener(this)

        mNextStepBtn.enable(mMobileEt, {isBtnEnabled()})
        mNextStepBtn.enable(mVerifyCodeEt, {isBtnEnabled()})
    }

    /**
     * 忘记密码回调
     */
    override fun onForgetPwdResult(result: String) {
        toast(result)
        // startActivity<ResetPwdActivity>("phone_num" to mMobileEt.text.toString())
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
            R.id.mVerifyCodeBtn -> {
                val phoneNum = mMobileEt.text
                if (phoneNum.isNullOrEmpty()) {
                    toast(resources.getString(R.string.user_center_s_phone_num_not_null))
                } else if (!PhoneNumUtils.checkPhoneNum(phoneNum.toString())) {
                    toast(resources.getString(R.string.user_center_s_regex_phone_num))
                } else {
                    mVerifyCodeBtn.requestSendVerifyNumber()
                    toast(resources.getString(R.string.user_center_s_send_phone_success))
                }
            }
            R.id.mNextStepBtn -> {
                startActivity<ResetPwdActivity>("phone_num" to mMobileEt.text.toString())
                mPresenter.forgetPwd(mMobileEt.text.toString(), mVerifyCodeEt.text.toString())
            }
        }
    }

    /**
     * 判断 Button 是否可用
     */
    private fun isBtnEnabled(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}