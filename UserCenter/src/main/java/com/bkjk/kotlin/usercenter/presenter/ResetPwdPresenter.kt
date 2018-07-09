package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.presenter.view.ResetPwdView
import com.bkjk.kotlin.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class ResetPwdPresenter @Inject constructor(): BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService : UserServiceImpl

    fun resetPwd(mobilePhone: String, pwd: String) {

        /**
         * 处理业务逻辑，如网络请求等等
         */

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.resetPwd(mobilePhone, pwd)
                .execute(object : BaseObserver<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onRestPwdResult(t)
                    }
                }, lifecycleProvider)
    }
}