package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo
import com.bkjk.kotlin.usercenter.presenter.view.LoginView
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class LoginPresenter @Inject constructor(): BasePresenter<LoginView>() {

    @Inject
    lateinit var userService : UserServiceImpl

    fun Login(mobilePhone: String, pwd: String, pushId: String) {

        /**
         * 处理业务逻辑，如网络请求等等
         */

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.login(mobilePhone, pwd, pushId)
                .execute(object : BaseObserver<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t)
                    }
                }, lifecycleProvider)
    }
}