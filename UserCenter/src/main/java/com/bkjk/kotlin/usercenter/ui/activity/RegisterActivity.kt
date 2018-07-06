package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bkjk.kotlin.baselibrary.ext.onClick
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

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onRegistered(result: String) {
        toast(result)
    }

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

        mRegisterBtn.onClick {
            mPresenter.onRegister(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
        }
        mHeaderBar.getRightView().text = "登录"
        mHeaderBar.getRightView().visibility = View.VISIBLE

        mVerifyCodeBtn.onClick {
            mVerifyCodeBtn.requestSendVerifyNumber()
        }
    }

    override fun initInjectionComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build().inject(this)
        mPresenter.mView = this
    }
}
