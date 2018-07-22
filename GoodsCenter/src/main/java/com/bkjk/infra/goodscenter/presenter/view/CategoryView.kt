package com.bkjk.infra.goodscenter.presenter.view

import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.kotlin.baselibrary.presenter.view.BaseView

interface CategoryView: BaseView {

    fun onGetCategoryResult(result: MutableList<Category>?)
}