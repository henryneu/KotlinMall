package com.bkjk.kotlin.baselibrary.ui.activity

import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T: BasePresenter<*>>: BaseActivity(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    @Inject
    lateinit var mPresenter: T
}