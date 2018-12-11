package com.bkjk.infra.goodscenter.data.api

import com.bkjk.infra.goodscenter.data.protocol.Category
import com.bkjk.infra.goodscenter.data.protocol.GetCategoryReq
import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import io.reactivex.Observable

interface CategoryApi {

    /**
     * 获取商品种类服务
     */
    @POST("categoryCenter/getCategory")
    fun getCategory(@Body req: GetCategoryReq) : Observable<BaseResp<MutableList<Category>?>>
}