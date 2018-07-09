package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.presenter.view.ForgetPwdView
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor(): BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService : UserServiceImpl

    fun forgetPwd(mobilePhone: String, verifyCode: String) {

        /**
         * 处理业务逻辑，如网络请求等等
         */

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.forgetPwd(mobilePhone, verifyCode)
                .execute(object : BaseObserver<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onForgetPwdResult(t)
                    }
                }, lifecycleProvider)
    }
}