package com.bkjk.kotlin.usercenter.ui.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.bkjk.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.bkjk.kotlin.usercenter.R
import com.bkjk.kotlin.usercenter.R.id.mRegisterBtn
import com.bkjk.kotlin.usercenter.presenter.RegisterPresenter
import com.bkjk.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onRegistered(boolean: Boolean) {
        toast("MVP模式下注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener {
/*            // Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            // Anko toast 的使用方式
            toast("注册")
            // Anko 启动 Activity 的两种使用方式
            startActivity(intentFor<TestActivity>("id" to 5).singleTop())
            // startActivity<TestActivity>("id" to 10)*/

            mPresenter = RegisterPresenter()
            mPresenter.mView = this

            mPresenter.onRegister("", "", "")
        }
    }
}
