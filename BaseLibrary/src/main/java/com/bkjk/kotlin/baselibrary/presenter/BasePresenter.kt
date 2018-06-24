package com.bkjk.kotlin.baselibrary.presenter

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView

open class BasePresenter<T: BaseView> {
    lateinit var mView: T
}