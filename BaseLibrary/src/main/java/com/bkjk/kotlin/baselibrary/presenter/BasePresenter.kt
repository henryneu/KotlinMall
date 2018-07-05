package com.bkjk.kotlin.baselibrary.presenter

import android.content.Context
import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T: BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    /**
     * 网络状态检测
     */
    fun checkNetWork(): Boolean {
        return NetWorkUtils.isNetWorkAvailable(context)
    }
}