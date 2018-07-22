package com.bkjk.infra.goodscenter.service

import com.bkjk.infra.goodscenter.data.protocol.Category
import io.reactivex.Observable

interface CategoryService {

    /**
     * 获取商品种类服务
     */
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}