package com.bkjk.infra.goodscenter.service.impl

import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.infra.goodscenter.data.repository.CategoryRepository
import com.bkjk.infra.goodscenter.service.CategoryService
import com.bkjk.kotlin.baselibrary.ext.convert
import io.reactivex.Observable
import javax.inject.Inject

class CategoryServiceImpl @Inject constructor(): CategoryService {

    @Inject
    lateinit var categoryRepository : CategoryRepository

    /**
     * 获取商品种类服务
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return categoryRepository.getCategory(parentId).convert()
    }
}