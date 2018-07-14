package com.bkjk.kotlin.usercenter.presenter

import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import com.bkjk.kotlin.usercenter.presenter.view.UserInfoView
import com.bkjk.kotlin.usercenter.service.UploadService
import com.bkjk.kotlin.usercenter.service.UserService
import javax.inject.Inject

class UserInfoPresenter @Inject constructor(): BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    fun getUploadToken() {
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadService.getUploadToken().execute(object : BaseObserver<String>(mView) {
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        }, lifecycleProvider)
    }
}