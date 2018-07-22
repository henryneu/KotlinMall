package com.bkjk.infra.goodscenter.ui.fragment

import android.os.Bundle
import android.view.View
import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.infra.goodscenter.presenter.CategoryPresenter
import com.bkjk.infra.goodscenter.presenter.view.CategoryView
import com.bkjk.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.bkjk.kotlin.baselibrary.ui.fragment.BaseMVPFragment

/**
 * 商品种类 Fragment
 */
class CategoryFragment: BaseMVPFragment<CategoryPresenter>(), CategoryView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** 初始化布局 */
        initView()
    }

    /**
     * 初始化布局
     */
    private fun initView() {
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
//        DaggerComponent.builder()
//                .activityComponent(activityComponent)
//                .userModule(UserModule())
//                .build().inject(this)
//        mPresenter.mView = this
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