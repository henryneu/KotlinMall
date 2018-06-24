package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.presenter.view.RegisterView
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl

class RegisterPresenter: BasePresenter<RegisterView>() {

    fun onRegister(mobilePhone: String, verificationCode: String, pwd: String) {

        /**
         * 处理业务逻辑，如网络请求等等
         */
        val userService = UserServiceImpl()
        userService.register(mobilePhone, verificationCode, pwd)
                .execute(object : BaseObserver<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegistered(t)
                    }
                })
    }
}