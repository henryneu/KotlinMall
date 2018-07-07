package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bkjk.kotlin.baselibrary.ext.enable
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.injection.component.DaggerUserComponent
import com.bkjk.kotlin.usercenter.injection.module.UserModule
import com.bkjk.kotlin.usercenter.presenter.RegisterPresenter
import com.bkjk.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.regex.Pattern

/**
 * 注册界面
 */
class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

/*        mRegisterBtn.setOnClickListener {
            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            // Anko toast 的使用方式
            toast("注册")
            // Anko 启动 Activity 的两种使用方式
            startActivity(intentFor<TestActivity>("id" to 5).singleTop())
            startActivity<TestActivity>("id" to 10)

            mPresenter.onRegister(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
        }*/

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mHeaderBar.getTitleView().text = resources.getString(R.string.user_center_s_register_btn)

        mVerifyCodeBtn.setOnClickListener(this)
        mRegisterBtn.setOnClickListener(this)

        mRegisterBtn.enable(mMobileEt, {isBtnEnabled()})
        mRegisterBtn.enable(mVerifyCodeEt, {isBtnEnabled()})
        mRegisterBtn.enable(mPwdEt, {isBtnEnabled()})
        mRegisterBtn.enable(mPwdConfirmEt, {isBtnEnabled()})
    }

    /**
     * 注册回调
     */
    override fun onRegistered(result: String) {
        toast(result)
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
            R.id.mRegisterBtn -> {
                if (mPwdEt.text.toString().equals(mPwdConfirmEt.text.toString())) {
                    mPresenter.onRegister(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
                } else {
                    toast(resources.getString(R.string.user_center_s_pwd_not_conformity))
                }
            }
            R.id.mVerifyCodeBtn -> {
                val phoneNum = mMobileEt.text
                if (phoneNum.isNullOrEmpty()) {
                    toast(resources.getString(R.string.user_center_s_phone_num_not_null))
                } else if (!checkPhoneNum(phoneNum.toString())) {
                    toast(resources.getString(R.string.user_center_s_regex_phone_num))
                } else {
                    mVerifyCodeBtn.requestSendVerifyNumber()
                    toast(resources.getString(R.string.user_center_s_send_phone_success))
                }
            }
        }
    }

    /**
     * 判断 Button 是否可用
     */
    private fun isBtnEnabled(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

    /***
     * 手机号码正则检测
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
     * <p>电信：133、153、173、177、180、181、189、199</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     *
     * @param  手机号码
     *
     * @return 是否匹配
     */
    private fun checkPhoneNum(num: String): Boolean {
        val regExp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"
        val p = Pattern.compile(regExp)
        val m = p.matcher(num)
        return m.matches()
    }
}
