package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.usercenter.presenter.view.RegisterView

class RegisterPresenter: BasePresenter<RegisterView>() {

    fun onRegister(mobilePhone: String, verificationCode: String, psd: String) {

        /**
         * 处理业务逻辑，如网络请求等
         */
        mView.onRegistered(true)
    }
}