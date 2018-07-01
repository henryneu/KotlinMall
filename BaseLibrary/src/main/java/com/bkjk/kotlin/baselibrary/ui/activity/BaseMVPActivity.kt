package com.bkjk.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.common.BaseApplication
import com.bkjk.kotlin.baselibrary.injection.component.ActivityComponent
import com.bkjk.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.bkjk.kotlin.baselibrary.injection.module.ActivityModule
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

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }
}