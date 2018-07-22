package com.bkjk.infra.goodscenter.data.repository

import com.bkjk.infra.goodscenter.data.api.CategoryApi
import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.kotlin.baselibrary.data.net.RetrofitFactory
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import javax.inject.Inject

class CategoryRepository @Inject constructor() {

    /**
     * 获取商品种类服务
     */
    fun getCategory(parentId: Int) : Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instances.create(CategoryApi::class.java)
                .getCategory(parentId)
    }
}