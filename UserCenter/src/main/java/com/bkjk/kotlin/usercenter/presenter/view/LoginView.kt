package com.bkjk.kotlin.usercenter.presenter.view

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import com.bkjk.kotlin.usercenter.date.protocol.UserInfo

interface LoginView: BaseView {

    fun onLoginResult(result: UserInfo)
}