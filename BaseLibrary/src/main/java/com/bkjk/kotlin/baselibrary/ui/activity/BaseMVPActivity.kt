package com.bkjk.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.bkjk.kotlin.baselibrary.common.BaseApplication
import com.bkjk.kotlin.baselibrary.injection.component.ActivityComponent
import com.bkjk.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.bkjk.kotlin.baselibrary.injection.module.ActivityModule
import com.bkjk.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.presenter.view.BaseView
import com.bkjk.kotlin.baselibrary.widgets.ProgressLoading
import javax.inject.Inject

abstract class BaseMVPActivity<T: BasePresenter<*>>: BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    /** 加载对话框 */
    private lateinit var mProgressDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()

        initInjectionComponent()

        mProgressDialog = ProgressLoading.create(this)
    }

    abstract fun initInjectionComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
        mProgressDialog.showLoading()
    }

    override fun hideLoading() {
        mProgressDialog.hideLoading()
    }

    override fun onError() {
    }
}