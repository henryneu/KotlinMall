package com.bkjk.infra.goodscenter.presenter

import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.infra.goodscenter.presenter.view.CategoryView
import com.bkjk.infra.goodscenter.service.impl.CategoryServiceImpl
import com.bkjk.kotlin.baselibrary.ext.execute
import com.bkjk.kotlin.baselibrary.presenter.BasePresenter
import com.bkjk.kotlin.baselibrary.rx.BaseObserver
import javax.inject.Inject

class CategoryPresenter @Inject constructor(): BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService : CategoryServiceImpl

    fun getCategory(parentId: Int) {

        /**
         * 处理业务逻辑，如网络请求等等
         */

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        categoryService.getCategory(parentId)
                .execute(object : BaseObserver<MutableList<Category>?>(mView) {
                    override fun onNext(t: MutableList<Category>?) {
                        mView.onGetCategoryResult(t)
                    }
                }, lifecycleProvider)
    }
}