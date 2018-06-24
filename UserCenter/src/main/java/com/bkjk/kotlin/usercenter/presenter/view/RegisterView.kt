package com.bkjk.kotlin.usercenter.presenter.view

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView

interface RegisterView: BaseView {

    fun onRegistered(result: Boolean)
}