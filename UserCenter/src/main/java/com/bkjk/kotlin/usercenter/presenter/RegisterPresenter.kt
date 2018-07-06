package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.presenter.view.RegisterView
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl
import com.kotlin.base.utils.NetWorkUtils
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService : UserServiceImpl

    fun onRegister(mobilePhone: String, verificationCode: String, pwd: String) {

        /**
         * 处理业务逻辑，如网络请求等等
         */

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobilePhone, verificationCode, pwd)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onRegistered("注册成功")
                        }
                    }
                }, lifecycleProvider)
    }
}