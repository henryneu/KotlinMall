package com.bkjk.infra.goodscenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkjk.infra.goodscenter.R
import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.infra.goodscenter.injection.component.DaggerCategoryComponent
import com.bkjk.infra.goodscenter.injection.module.CategoryModule
import com.bkjk.infra.goodscenter.presenter.CategoryPresenter
import com.bkjk.infra.goodscenter.presenter.view.CategoryView
import com.bkjk.kotlin.baselibrary.ui.fragment.BaseMVPFragment

/**
 * 商品种类 Fragment
 */
class CategoryFragment: BaseMVPFragment<CategoryPresenter>(), CategoryView, View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
        mPresenter.getCategory(0)
    }

    /**
     * 登录回调
     */
    override fun onGetCategoryResult(result: MutableList<Category>?) {
        // toast(resources.getString(R.string.user_center_s_login_success))
    }

    /**
     * 初始化依赖注入
     */
    override fun initInjectionComponent() {
        DaggerCategoryComponent.builder()
                .activityComponent(activityComponent)
                .categoryModule(CategoryModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 处理点击事件
     */
    override fun onClick(view: View) {
        when(view.id) {
            // 测试使用

        }
    }
}