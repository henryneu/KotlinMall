package com.bkjk.kotlin.baselibrary.presenter

import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T: BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}