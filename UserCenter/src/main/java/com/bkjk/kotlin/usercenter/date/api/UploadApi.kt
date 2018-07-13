package com.bkjk.kotlin.usercenter.date.api

import com.bkjk.kotlin.baselibrary.data.protocol.BaseResp
import retrofit2.http.POST
import io.reactivex.Observable

interface UploadApi {

    /**
     * 获取上传所需 Token 凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken() : Observable<BaseResp<String>>
}